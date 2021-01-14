package com.xiaobu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2021/1/8 15:24
 * @description
 */
@RefreshScope
@RestController
public class TestController {
    /**
     * 通过@Value 来将配置文件中的值写入到代码中
     */
    @Value("${from}")
    String from;

    @RequestMapping("/from")
    public String from() {
        return from;
    }
}
