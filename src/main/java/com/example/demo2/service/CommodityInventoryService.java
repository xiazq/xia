package com.example.demo2.service;

import com.example.demo2.entity.CommodityInventory;

import java.util.List;

public interface CommodityInventoryService {

    boolean update(CommodityInventory commodityInventory);

    CommodityInventory queryByCName(String cname);

    List<CommodityInventory> queryAll();

}
