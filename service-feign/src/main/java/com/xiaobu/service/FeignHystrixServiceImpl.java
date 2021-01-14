package com.xiaobu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2021/1/7 15:59
 * @description
 */

@Component
public class FeignHystrixServiceImpl implements FeignService {

    @Override
    public String testFromClient(String name) {
        return "sorry " + name + ",this service is unavailable";
    }
}
