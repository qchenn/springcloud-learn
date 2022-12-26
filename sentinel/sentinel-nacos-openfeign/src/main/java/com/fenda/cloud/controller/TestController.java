package com.fenda.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fenda
 * @create 2022/12/26 08:22
 */

@RestController
public class TestController {


//    sentinel控制台是懒加载，启动服务需先调一次接口，控制台才能显示该服务

    /**
     *
     * 规则持久化配置在nacos，sentinel控制台会从nacos读取规则配置，再作用所指定的资源，这样重启服务不许重配规则，自动生效
     *
     * [
     *     {
     *         "resource":"hello",
     *         "limitApp":"default",
     *         "grade":1,
     *         "count":1,
     *         "strategy":0,
     *         "controlBehavior":0,
     *         "clusterMode": false
     *     }
     * ]
     *
     *
     *
     *
     */
    @SentinelResource(value = "hello",blockHandler = "helloBlockHandle")
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello,"+name;
    }

    public String helloBlockHandle(String name, BlockException e){
        e.printStackTrace();
        return "limit flaw,"+name;
    }

}
