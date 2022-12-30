package com.fenda.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fenda
 * @create 2022/12/30 08:06
 */

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback(){
        return "gateway fallback。。。。";
    }
}
