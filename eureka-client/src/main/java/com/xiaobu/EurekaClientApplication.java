package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
@Slf4j
public class EurekaClientApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "admin") String name) {
        return name +",test ,i am from port:" + port;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info(" service-client  在端口{} 启动成功.....",port);

    }
}
