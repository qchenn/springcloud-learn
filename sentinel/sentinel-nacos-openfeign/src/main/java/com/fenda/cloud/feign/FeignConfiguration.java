package com.fenda.cloud.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fenda
 * @create 2022/12/26 09:11
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public ApiFallbck apiFallbck(){
        return new ApiFallbck();
    }
}
