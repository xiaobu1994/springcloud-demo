package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
@Slf4j
public class ServiceZuulApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info(" service-zuul  在端口{} 启动成功.....",port);

    }

}
