## rabb-springcloud-demo

用于学习SpringCloud的仓库，相关文章见：https://blog.lazyrabbit.xyz/tags/#SpringCloud

### 组件

- 服务发现/治理：Eureka Nacos Zookeeper Consul
- 配置中心：Config Nacos Zookeeper Consul
- 远程调用：OpenFeign
- 客户端负载均衡：Ribbon
- 熔断/流量控制：Hystrix Sentinel
- 网关：Zuul Gateway
- 链路追踪：Sleuth&Zipkin Skywalking
- 消息总线：Bus
- 消息驱动：Stream
- 分布式事务：Seata

### 版本关系

##### Spring相关依赖版本

组件 | SpringBoot | SpringCloud | SpringCloudAlibaba
---|---|---|---
Eureka | 2.4.2 | 2020.0.1(Ilford) | -
Ribbon | 2.3.8.RELEASE | Hoxton.SR10 | -
Hystrix | 2.3.8.RELEASE | Hoxton.SR10 | -
OpenFeign | 2.3.8.RELEASE | Hoxton.SR10 | -
Zuul | 2.3.8.RELEASE | Hoxton.SR10 | -
Config | 2.4.2 | 2020.0.1(Ilford) | -
Sleuth | 2.4.2 | 2020.0.1(Ilford) | -
Bus | 2.4.2 | 2020.0.1(Ilford) | -
Stream | 2.6.2 | 2021.0.0 | -
Consul | 2.6.2 | 2021.0.0 | -
Nacos | 2.3.12.RELEASE | - | 2.2.7.RELEASE
Zookeeper | 2.6.2 | 2021.0.0 | -
Gateway | 2.6.3 | 2021.0.0 | -
Sentinel | 2.3.12.RELEASE | Hoxton.SR12 | 2.2.7.RELEASE
Seata | 2.3.12.RELEASE | Hoxton.SR12 | 2.2.7.RELEASE

##### 外部组件版本

组件 | 版本
---|---
Consul | 1.10.6
Nacos | 2.0.3
Zookeeper | 3.7.0
Kafka | 2.12-2.8.1
Sentinel | 1.8.3
Zipkin | 2.23.2
Skywalking | 8.9.1
