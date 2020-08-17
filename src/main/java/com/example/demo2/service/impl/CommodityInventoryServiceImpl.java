package com.example.demo2.service.impl;

import com.example.demo2.dao.CommodityInventoryDao;
import com.example.demo2.entity.CommodityInventory;
import com.example.demo2.service.CommodityInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityInventoryServiceImpl implements CommodityInventoryService {

    @Autowired
    private CommodityInventoryDao commodityInventoryDao;



    @Override
    public boolean update(CommodityInventory commodityInventory) {
//        return commodityInventoryDao.update(commodityInventory) > 0;
        return commodityInventoryDao.update(commodityInventory);
    }

    @Override
    public CommodityInventory queryByCName(String cname) {
        return commodityInventoryDao.queryByCName(cname);
    }

    @Override
    public List<CommodityInventory> queryAll() {
        /*Jedis jedis = JedisUtil.getJedis();
        List<CommodityInventory> commodityInventories = commodityInventoryDao.queryAll();
        for (CommodityInventory commodityInventory : commodityInventories) {
            if (jedis.get("kill") + commodityInventory.getId() == null) {
                jedis.set("kill" + commodityInventory.getId(), commodityInventory.getInventory().toString(),"NX","EX",10000);
            }
        }*/

        return commodityInventoryDao.queryAll();
    }
}
