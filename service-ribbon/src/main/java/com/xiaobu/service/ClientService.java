package com.xiaobu.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2021/1/7 14:42
 * @description
 */
@Service
public class ClientService {
    @Autowired
    RestTemplate restTemplate;


    /***
     * @author xiaobu
     * @date 2018/11/6 11:42
     * @param name 名字
     * @return java.lang.String
     * @descprition  直接用的程序名替代了具体的url地址，
     * 在ribbon中它会根据服务名来选择具体的服务实例，
     * 根据服务实例在请求的时候会用具体的url替换掉服务名
     * @version 1.0
     */
    @HystrixCommand(fallbackMethod ="error" )
    public String clientService(String name){
        return restTemplate.getForObject("http://eureka-client/test?name=" + name, String.class);
    }

    /**
     * @author xiaobu
     * @date 2018/11/7 11:27
     * @param name 名字
     * @return java.lang.String
     * @descprition  error要与  @HystrixCommand(fallbackMethod ="error" )的方法名要相对应
     * @version 1.0
     */
    public String error(String name){
        return "hi "+name+",this service is  unavailable ";
    }


}
