package com.fenda.cloud.order.api;


import com.fenda.cloud.nomal.CommonResult;
import com.fenda.cloud.order.bean.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "seata-order-service")
public interface OrderServce {


    /**
     * 创建订单
     */
    @GetMapping("/order/create")
     CommonResult create(Order order);
}
