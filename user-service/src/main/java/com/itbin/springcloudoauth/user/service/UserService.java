package com.itbin.springcloudoauth.user.service;

import com.itbin.springcloudoauth.user.data.dto.UserDto;

/**
 * Created by LIBIN on 2018/11/17 1:50
 * Description:
 */
public interface UserService {

    UserDto findByUsername(String username);
}
