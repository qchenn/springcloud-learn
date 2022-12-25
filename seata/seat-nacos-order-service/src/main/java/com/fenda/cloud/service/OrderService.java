package com.fenda.cloud.service;


import com.fenda.cloud.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
