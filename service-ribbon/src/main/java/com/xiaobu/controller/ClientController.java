package com.xiaobu.controller;
import com.xiaobu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/6 11:36
 * @description V1.0
 */
@RestController
public class ClientController {
    @Autowired
    ClientService clientService;


    @GetMapping("/test")
    public String test(@RequestParam String name){
        return clientService.clientService(name);
    }
}