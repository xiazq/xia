package com.example.demo2.dao;

import com.example.demo2.entity.CommodityInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityInventoryDao {


    CommodityInventory queryByCName(String cname);

    List<CommodityInventory> queryAll();

    boolean update(CommodityInventory commodityInventory);

}