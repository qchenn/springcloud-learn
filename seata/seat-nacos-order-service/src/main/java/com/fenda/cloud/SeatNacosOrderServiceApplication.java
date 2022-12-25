package com.fenda.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan({"com.fenda.cloud.dao"})
//https://blog.csdn.net/weixin_53974140/article/details/122326257
//要配置需要扫描的feign接口包名，不然接口会注入失败，
@EnableFeignClients(basePackages = "com.fenda.cloud")
//@EnableDiscoveryClient
public class SeatNacosOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatNacosOrderServiceApplication.class, args);
    }

}
