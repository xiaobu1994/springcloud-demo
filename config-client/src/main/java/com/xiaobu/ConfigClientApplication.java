package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaobu
 */
@SpringBootApplication
@Slf4j
public class ConfigClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        log.info("config-client 在端口{}启动成功", port);
    }
}
