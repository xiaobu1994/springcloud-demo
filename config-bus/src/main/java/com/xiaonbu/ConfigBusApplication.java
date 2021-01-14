package com.xiaonbu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
@Slf4j
public class ConfigBusApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConfigBusApplication.class, args);
    }


    @Value("${server.port}")
    private String port;


    @Override
    public void run(String... args) throws Exception {
        log.info("config-client 在端口{}启动成功", port);
    }


    @Value("${from}")
    String from;

    @GetMapping("/from")
    public String from() {
        return from;
    }
}
