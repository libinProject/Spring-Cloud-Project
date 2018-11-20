package com.itbin.springcloudoauth.order.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LIBIN on 2018/11/17 15:52
 * Description:
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @RequestMapping(value = "/getorder")
    public String getOrder(){
        return "order";
    }
}
