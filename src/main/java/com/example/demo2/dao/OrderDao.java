package com.example.demo2.dao;

import com.example.demo2.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    int insert(Order order);


    int update(Order order);

    //根据订单编号
    Order selectById(int id);
}