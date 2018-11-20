package com.itbin.springcloudoauth.user.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by LIBIN on 2018/11/17 1:42
 * Description:
 */
@Data
@Table(name = "rc_user")
public class User {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String avatar;

    private String username;

    private String password;

    private String salt;

    private String name;

    private Timestamp birthday;

    private Integer sex;

    private String email;

    private String phone;

    private Integer status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;
}
