package com.fenda.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author fenda
 * @create 2022/12/26 09:06
 */
// https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel
@FeignClient(value = "provide",contextId = "primary",fallback = ApiFallbck.class,configuration = FeignConfiguration.class)
public interface Api {

    @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
    String say(@PathVariable("name") String name);
}
