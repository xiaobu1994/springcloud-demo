package com.xiaobu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@Slf4j
public class ServiceRibbonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }


    /***
     * @author xiaobu
     * @date 2018/11/6 11:32
     * @return org.springframework.web.client.RestTemplate
     * @descprition restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
     * @version 1.0
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }



    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info(" service-ribbon  在端口{} 启动成功.....",port);

    }
}
