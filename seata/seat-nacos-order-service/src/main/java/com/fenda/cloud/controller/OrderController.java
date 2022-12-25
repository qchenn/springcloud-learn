package com.fenda.cloud.controller;


import com.fenda.cloud.domain.Order;
import com.fenda.cloud.service.OrderService;
import com.fenda.cloud.nomal.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult("订单创建成功!", 200);
    }
}
