package com.fenda.cloud.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author fenda
 * @create 2022/12/31 02:27
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;
    //通过服务名调哟过
    @GetMapping("/consumer")
    public String consumer(){
        return "consumer call->"+restTemplate.getForObject("http://nacos-provider-service/provider",String.class);
    }
}
