package com.itbin.springcloudoauth.user.web;

import com.itbin.springcloudoauth.user.data.dto.ResultDto;
import com.itbin.springcloudoauth.user.data.dto.UserDto;
import com.itbin.springcloudoauth.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LIBIN on 2018/11/16 17:02
 * Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("findByUsername/{username}")
    public ResultDto findUserByName(@PathVariable("username") String username){

        UserDto userDto = userService.findByUsername(username);

        return ResultDto.builder().data(userDto).build();

    }
}
