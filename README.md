# springcloud-learn
 record learnning springcloud
##系统环境

    jdk1.8
    spring-cloud-alibaba 2021.0.4.0
    spring-cloud 2021.0.4.0
    spring-boot 2.6.11
[版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)



##模块介绍
###一、[seata](http://seata.io/zh-cn/docs/overview/what-is-seata.html)
    1、环境要求
       seata-server（配置文件注意数据库驱动版本）
       mysql(需建立3个库，每个库所需表在各模块下)
       nacos
    2、模块解析
       common：接口、bean二方包
       seata-nacos-account-service:账户服务，用到nacos服务注册、openfeign远程调用
       seata-nacos-order-service：订单服务，用到nacos服务注册、openfeign远程调用
       seata-nacos-storage-service：库存服务，用到nacos服务注册、openfeign远程调用
       order服务下订单会去调用账户服务、库存服务进行扣减，在下订单开启全局事务保证分布式一致性，使用的是seat的AT模式，每个库借助undo log实现一致性
[seat四种模式介绍](https://seata.io/zh-cn/docs/dev/mode/at-mode.html)


###二、[sentinel](https://github.com/alibaba/Sentinel/wiki)
    1、使用sentinel的限流、熔断
    （1）环境要求
        sentinel控制台
        nacos
    （2）模块解析
        sentinel-test：测试sentinel的限流、熔断
        sentinel-nacos-openfeign：使用openfeign服务调用、nacos注册中心，测试限流
###三、[canal](https://github.com/alibaba/canal/wiki)
    1、使用canal监听binlog日志
    （1）环境要求
        安装canel-deployer：server、mysql
    （2）canal-test：canal客户端，实现对sql的监听
###四、[gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)

    1、使用gataway路由、测试内置predicate断言、filter过滤器 [doc]()
    （1）环境要求
        gateway filter实现限流需安装redis
    （2）模块解析
        api-gateway：网关服务，配置文件prediate、filter分别对内置的断言、过滤器进行了测试，可通过切换配置文件尝试
        order-service:订单服务
        user-service:用户服务
   
###五、[nacos](https://github.com/alibaba/spring-cloud-alibaba/wiki)
    1、使用nacos注册中心、配置中心
    （1）环境要求
        需安装nacos
    （2）模块解析
        nacos-consumer-service：服务调用者，用到nacos注册中心、RestTamplate远程服务调用（带负载均衡）
        nacos-provider-service：服务提供者，用到nacos注册中心、nacos配置中心
        consumer借助RestTemplate远程通过服务名调用prider
