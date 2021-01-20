package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
@Slf4j
public class HighAvailabilityServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighAvailabilityServiceHiApplication.class, args);
    }

}
