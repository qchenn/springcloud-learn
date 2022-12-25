package com.fenda.cloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fenda.cloud.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author fenda
 * @create 2022/12/25 18:44
 */

@Service
public class TestServiceImpl implements TestService {

//注解详解  https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81


    /**
     * 限流
     *
     */
    //value要于控制台的资源名对应，否则不生效
    @Override
    @SentinelResource(value = "sayHello",fallback = "helloFallback", blockHandler = "exceptionHandler")
    public String sayHello(String name) {
        return "Hello,"+name;
    }


    /**
     * 熔断
     * 慢调用比例模式配置：
     *最大RT100ms，比例阈值0.1,熔断时长5s,最小请求数 1,统计时长1000ms规则下
     * 调用一次超过1s,达到规则后会熔断，5s内全部降级处理
     *
     *
     */
    @Override
    @SentinelResource(value = "say",fallback = "sayFallback")
    public String say(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "say"+name;
    }


    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String sayFallback(String s) {
        return String.format("熔断", s);
    }

    //有block走block，没就走fallback，对blockException及其子类+所有异常都有效
    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String helloFallback(String s) {
        return String.format("Halooooo", s);
    }


    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(String s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

    // 这里单独演示 blockHandlerClass 的配置.
    // 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 public static 函数.
//    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
//    public void test() {
//        System.out.println("Test");
//    }












}
