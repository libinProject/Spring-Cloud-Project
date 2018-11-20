package com.itbin.springcloudoauth.user.data.dto;

import lombok.Data;

/**
 * Created by LIBIN on 2018/11/17 1:46
 * Description:
 */
@Data
public class UserDto {

    private String id;

    private String avatar;

    private String username;

    private String password;

    private String salt;

    private String name;

    private String birthday;

    private String sex;

    private String email;

    private String phone;

    private Integer status;

    private String createTime;

    private String updateTime;
}
