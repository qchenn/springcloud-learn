package com.fenda.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan({"com.fenda.cloud.dao"})
@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class SeataNacosStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataNacosStorageServiceApplication.class, args);
    }

}
