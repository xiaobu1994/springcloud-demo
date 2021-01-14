package com.xiaobu.controller;

import com.xiaobu.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2021/1/7 15:12
 * @description
 */
@RestController
public class FeginController {
    @Autowired
    FeignService feignService;


    @GetMapping("/test")
    public String test(@RequestParam String name){
        return feignService.testFromClient(name);
    }

}
