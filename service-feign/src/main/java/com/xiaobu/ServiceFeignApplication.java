package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@Slf4j
public class ServiceFeignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }


    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info(" service-feign  在端口{} 启动成功.....",port);

    }
}
