package com.example.demo2.service;

import com.example.demo2.entity.Order;

public interface OrderService {
    Integer insert(Order order);

    Integer update(Order order);

    Order selectById(int id);

}
