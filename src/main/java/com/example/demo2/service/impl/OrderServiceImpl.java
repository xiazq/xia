package com.example.demo2.service.impl;

import com.example.demo2.dao.OrderDao;
import com.example.demo2.entity.Order;
import com.example.demo2.service.OrderService;
import com.example.demo2.util.JedisUtil;
import com.example.demo2.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;



    @Override
    public Integer insert(Order order) {
//        Jedis jedis = JedisUtil.getJedis();
        //判断是否超时
//        if(!"-2".equals(jedis.ttl(("order" + order.getUserName()).getBytes()))) {
//            Order unserialize = (Order) SerializeUtil.unserialize(jedis.get(("order" + order.getUserName()).getBytes()));
//            //添加订单
//            orderDao.insert(order);
//        }else {
//            //找到对应商品在redis里面的库存
//            int inventory = Integer.parseInt(jedis.get("kill" + order.getCiId()));
//            inventory = inventory+1;
//
//
//            //redis里面库存+1
//            jedis.set("kill" + order.getCiId(),inventory+"");
//            throw new RuntimeException("订单以超时");
//        }
        return orderDao.insert(order);
    }

    @Override
    public Integer update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public Order selectById(int id) {
        return orderDao.selectById(id);
    }


}
