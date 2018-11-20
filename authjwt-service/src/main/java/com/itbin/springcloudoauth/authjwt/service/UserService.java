package com.itbin.springcloudoauth.authjwt.service;

import com.itbin.springcloudoauth.authjwt.data.dto.ResultDto;
import com.itbin.springcloudoauth.authjwt.data.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LIBIN on 2018/11/19 14:48
 * Description:
 */
@FeignClient(name = "user-service")
public interface UserService {

    @RequestMapping(value = "/user/findByUsername/{username}")
    ResultDto<UserDto> findByUsername(@PathVariable("username") String username);
}