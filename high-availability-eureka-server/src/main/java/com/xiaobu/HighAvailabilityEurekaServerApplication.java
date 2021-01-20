package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xiaobu
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class HighAvailabilityEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighAvailabilityEurekaServerApplication.class, args);
    }

}
