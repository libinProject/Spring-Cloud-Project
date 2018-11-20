package com.itbin.springcloudoauth.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LIBIN on 2018/11/19 15:00
 * Description:
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @RequestMapping(value = "/getorder")
    public String getOrder(){
        return "JWTOrder";
    }
}
