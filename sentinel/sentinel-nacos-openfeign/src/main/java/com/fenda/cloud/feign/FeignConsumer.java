package com.fenda.cloud.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author fenda
 * @create 2022/12/26 09:20
 */

@RestController
public class FeignConsumer {

    @Resource
    private Api api;

    @GetMapping("/say/{name}")
    public String say(@PathVariable String name){
        return api.say(name);
    }
}
