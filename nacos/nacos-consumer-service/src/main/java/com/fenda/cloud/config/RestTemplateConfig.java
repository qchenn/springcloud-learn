package com.fenda.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author fenda
 * @create 2022/12/31 02:29
 */
//使用restTemplate进行远程调用
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced    //通过服务名调用需加上负载均衡注解，同时pom添加spring-cloud-loadbalancer
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
