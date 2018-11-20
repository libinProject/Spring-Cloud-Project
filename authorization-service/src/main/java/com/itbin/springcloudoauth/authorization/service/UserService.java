package com.itbin.springcloudoauth.authorization.service;

import com.itbin.springcloudoauth.authorization.data.dto.ResultDto;
import com.itbin.springcloudoauth.authorization.data.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LIBIN on 2018/11/17 2:14
 * Description:
 */
@FeignClient(name = "user-service")
public interface UserService {

    @RequestMapping(value = "/user/findByUsername/{username}")
    ResultDto<UserDto> findByUsername(@PathVariable("username") String username);
}
