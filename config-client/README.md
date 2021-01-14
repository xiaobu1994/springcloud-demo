

学习springcloud 配置一个config-client，需要配置一个config-server的地址。

在application.properties中配置了spring.cloud.config.uri=http://localhost:7002。没有按网上的例子配置成8888.

结果发现这个配置总是不生效，还是访问默认配置的8888.

网上找答案，果然有人跟我遇到同样的问题，增加一个bootstrap.properties配置文件。在这个文件增加配置spring.cloud.config.uri

bootstrap.properties 优先级高于 application.properties

这样果然生效。



# 



##  从config-server获取配置信息

```properties
server.port=7002
#{application}
spring.application.name=xiaobu
#{profile}
spring.cloud.config.profile=dev
#{label}
spring.cloud.config.label=master

 spring.cloud.config.uri=http://localhost:7001/
```


## 从eureka-server获取配置信息

```properties

spring.application.name=config-client
spring.cloud.config.label=master
spring.cloud.config.profile=dev
spring.cloud.config.uri= http://localhost:8888/

eureka.client.serviceUrl.defaultZone=http://localhost:8001/eureka/
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.serviceId=config-server
server.port=7002
```