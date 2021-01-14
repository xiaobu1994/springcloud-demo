package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@Slf4j
@EnableConfigServer
public class ConfigServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }



    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info(" config-server  在端口{} 启动成功.....",port);
    }
}
