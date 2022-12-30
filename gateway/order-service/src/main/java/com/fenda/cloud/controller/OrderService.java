package com.fenda.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fenda
 * @create 2022/12/30 02:18
 */

@RestController
public class OrderService {

    @GetMapping("/order/{id}")
    public String selectOrderById(@PathVariable("id") Integer id){
        return "order:"+id;
    }
}
