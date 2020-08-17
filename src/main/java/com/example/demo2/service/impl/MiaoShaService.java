package com.example.demo2.service.impl;

import com.example.demo2.entity.CommodityInventory;
import com.example.demo2.entity.Order;
import com.example.demo2.service.CommodityInventoryService;
import com.example.demo2.service.OrderService;
import com.example.demo2.util.JedisUtil;
import com.example.demo2.util.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Slf4j
public class MiaoShaService {


    @Autowired
    private CommodityInventoryService commodityInventoryService;


    @Autowired
    private OrderService orderService;



    @PostConstruct
    public void getInventory() {
        Jedis template = JedisUtil.getJedis();

        List<CommodityInventory> commodityInventories = commodityInventoryService.queryAll();
        for (CommodityInventory commodityInventory : commodityInventories) {
            if (template.get("kill" + commodityInventory.getId()) == null) {
//                template.set("kill" + commodityInventory.getId(), commodityInventory.getInventory().toString(),"NX","EX",10000);
                template.set("kill" + commodityInventory.getId(), commodityInventory.getInventory().toString());
                System.out.println(commodityInventory.getCname()+"更新库存成功");
            }
        }
        template.close();
    }

    @Scheduled(cron = "*/15 * * * * ?")
    public String dingDan() {
        Jedis template = JedisUtil.getJedis();

        Set<byte[]> keys = template.keys("order*".getBytes());
        for (byte[] key : keys) {
            template.get(key);
            Order unserialize = (Order) SerializeUtil.unserialize(template.get(key));
            if (unserialize.getTime() - System.currentTimeMillis() < 0) {
                if (unserialize.getStatus() != 1) {
                    unserialize.setStatus(0);
                    orderService.update(unserialize);
                    String s = template.get("kill" + unserialize.getCiId());
                    int inventory = Integer.parseInt(s);
                    inventory++;
                    //库存+1
                    template.set("kill" + unserialize.getCiId(), String.valueOf(inventory));
                    System.out.println("已经超时,未支付,订单取消");
                    template.del(key);
                } else {
                    orderService.update(unserialize);
                    template.del(key);
                }
            }
        }
        template.close();
        return "";
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void setInventory() {
        Jedis template = JedisUtil.getJedis();
        Set<byte[]> keys = template.keys("order*".getBytes());
        if (keys.size() == 0) {
            List<CommodityInventory> commodityInventories = commodityInventoryService.queryAll();
            for (CommodityInventory commodityInventory : commodityInventories) {
                if (template.get("kill" + commodityInventory.getId()) != null) {
                    int inventory = Integer.parseInt(template.get("kill" + commodityInventory.getId()));
                    commodityInventory.setInventory(inventory);
                    commodityInventoryService.update(commodityInventory);
                    template.del("kill" + commodityInventory.getId());
                }
            }
        }
        template.close();

    }
    //订单编号获取订单
    public String maidan(Integer id) {

        Order order = orderService.selectById(id);
        order.setGxTime(new Date());
        if (System.currentTimeMillis() - order.getCreatTime().getTime() < 60000) {
            //未超时 修改状态
            order.setStatus(1);
            orderService.update(order);
            return "支付成功";
        }else {
            //已经超时未支付
            Jedis template = JedisUtil.getJedis();
            order.setStatus(0);
            orderService.update(order);
            String s = template.get("kill" + order.getCiId());
            int inventory = Integer.parseInt(s);
            inventory++;
            //库存+1
            template.set("kill" + order.getCiId(), String.valueOf(inventory));

            template.close();
            return "超时未支付";
        }
    }

    public String miaosha(Integer id, String username, String cname) {
        Jedis template = JedisUtil.getJedis();

        template.watch("kill" + id.toString());

        String s = template.get("kill" + id.toString());
        int inventory = Integer.parseInt(s);
        Order order = new Order();
        if (inventory > 0) {
            //更新库存
            inventory--;
            Transaction multi = template.multi();
//            template.opsForValue().set("kill" + id.toString(), Integer.toString(inventory));
            multi.set("kill" + id, String.valueOf(inventory));


            List<Object> exec = multi.exec();
//            System.out.println(exec);
            if (exec != null) {
//                System.out.println("操作成功");
                order.setId(1);
                order.setCiId(id);
                order.setCname(cname);
                order.setUserName(username);
                order.setStatus(2);
                System.currentTimeMillis();
                //时间
                order.setTime(System.currentTimeMillis() + 60000);
                byte[] serialize = SerializeUtil.serialize(order);
                String uuid = "order" + UUID.randomUUID().toString();
                template.set(uuid.getBytes(), serialize);
//                //创建订单
                orderService.insert(order);
                System.out.println("订单添加成功");
                log.info("请求成功:{}", username, System.currentTimeMillis());
                template.unwatch();
                template.close();
                return uuid;
            }
        }
//         else {
//            CommodityInventory commodityInventory = new CommodityInventory();
//            commodityInventory.setId(id);
//            commodityInventory.setInventory(0);
//            boolean update = commodityInventoryService.update(commodityInventory);
//            if(!update)throw new RuntimeException();09:18:33.712  09:18:35.993
//        }
        template.unwatch();
        template.close();
        return "";
    }


}
