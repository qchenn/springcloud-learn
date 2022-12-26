package com.fenda.cloud.feign;

/**
 * @Author fenda
 * @create 2022/12/26 09:13
 */

public class ApiFallbck implements Api{
    @Override
    public String say(String name) {
        return "降级,fallback,"+name;
    }
}
