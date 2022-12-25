package com.fenda.cloud.controller;

import com.fenda.cloud.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author fenda
 * @create 2022/12/25 18:44
 */

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name){
        return testService.sayHello(name);
    }


    @GetMapping("/say/{name}")
    public String say(@PathVariable String name){
        return testService.say(name);
    }

}
