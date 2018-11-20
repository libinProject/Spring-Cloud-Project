package com.itbin.springcloudoauth.user.service.Impl;

import com.itbin.springcloudoauth.user.data.dto.UserDto;
import com.itbin.springcloudoauth.user.mapper.UserMapper;
import com.itbin.springcloudoauth.user.model.User;
import com.itbin.springcloudoauth.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

/**
 * Created by LIBIN on 2018/11/17 2:06
 * Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto findByUsername(String username) {

        Example example = Example.builder(User.class)
                .where(Sqls.custom().andEqualTo("username",username))
                .build();

        User user = userMapper.selectOneByExample(example);

        return modelConvertDto(user);
    }

    private UserDto modelConvertDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId()+"");
        userDto.setAvatar(user.getAvatar());
        userDto.setPassword(user.getPassword());
        userDto.setSalt(user.getSalt());
        userDto.setUsername(user.getUsername());

        return userDto;
    }
}
