package com.itbin.springcloudoauth.authjwt.service.Impl;

import com.itbin.springcloudoauth.authjwt.data.dto.ResultDto;
import com.itbin.springcloudoauth.authjwt.data.dto.UserDto;
import com.itbin.springcloudoauth.authjwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LIBIN on 2018/11/19 14:49
 * Description:
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ResultDto<UserDto> userDtoResultDto = userService.findByUsername(username);
        if(userDtoResultDto.getIsSuccess()){

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            boolean enabled = true; // 可用性 :true:可用 false:不可用
            boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
            boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
            boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_super");
            grantedAuthorities.add(grantedAuthority);

            User user = new User(userDtoResultDto.getData().getUsername(), userDtoResultDto.getData().getPassword(),
                    enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
            return user;

        }else {
            throw new UsernameNotFoundException("username not fond");
        }

    }
}
