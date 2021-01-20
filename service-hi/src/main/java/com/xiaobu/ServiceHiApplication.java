package com.xiaobu;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaobu
 */
@SpringBootApplication
@RestController
@Slf4j
public class ServiceHiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    private String port;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("service-hi在端口： " +port+"启动完成....." );
    }


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String callHome(){
        log.info("calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    @GetMapping("/info")
    public String info(){
        log.info("calling trace service-hi ");
        return "i'm service-hi";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


}
