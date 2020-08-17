package com.example.demo2.service;

import com.example.demo2.config.MyRabbitMQConfig;
import com.example.demo2.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQOrderService {
    private static Logger log = LoggerFactory.getLogger(MQOrderService.class);
    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = MyRabbitMQConfig.ORDER_QUEUE)
    public void createOrder(Order order) {
        log.info("收到订单消息，订单用户为：{}，商品名称为：{}", order.getUserName(), order.getCname());
        /**
         * 调用数据库orderService创建订单信息
         */
        this.orderService.insert(order);
    }


}
