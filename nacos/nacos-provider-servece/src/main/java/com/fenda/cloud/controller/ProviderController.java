package com.fenda.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fenda
 * @create 2022/12/31 02:23
 */

@RestController
@Slf4j
@RefreshScope
public class ProviderController {
    //测试nacos配置中心
    @Value("${configFromNacos}")
    private String configFromNacos;

    @GetMapping("/provider")
    public String provider(){
        log.info("provider......");
        log.info("this is "+configFromNacos);
        return "this is provider";
    }
}
