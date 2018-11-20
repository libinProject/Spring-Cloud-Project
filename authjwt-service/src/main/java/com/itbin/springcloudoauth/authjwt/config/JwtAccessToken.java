package com.itbin.springcloudoauth.authjwt.config;

import com.itbin.springcloudoauth.authjwt.data.dto.BaseUser;
import com.itbin.springcloudoauth.authjwt.data.utils.JsonUtils;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * Created by LIBIN on 2018/11/19 17:26
 * Description:
 */
public class JwtAccessToken extends JwtAccessTokenConverter implements TokenEnhancer {

    /**
     * 生成token
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
//        // 设置额外用户信息
//        User user = (User) authentication.getPrincipal();
//        BaseUser baseUser=new BaseUser();
//        baseUser.setUserName(user.getUsername());
//        System.out.println(baseUser);
//        // 将用户信息添加到token额外信息中
//        //defaultOAuth2AccessToken.getAdditionalInformation().put("USER_INFO", baseUser);
//        System.out.println(super.enhance(defaultOAuth2AccessToken, authentication));



        return super.enhance(defaultOAuth2AccessToken, authentication);

    }

    /**
     * 解析token
     * @param value
     * @param map
     * @return
     */
    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map){
        OAuth2AccessToken oauth2AccessToken = super.extractAccessToken(value, map);
        convertData(oauth2AccessToken, oauth2AccessToken.getAdditionalInformation());
        return oauth2AccessToken;
    }

    private void convertData(OAuth2AccessToken accessToken,  Map<String, ?> map) {

        accessToken.getAdditionalInformation().put("USER_INFO",convertUserData(map.get("USER_INFO")));

    }

    private BaseUser convertUserData(Object map) {
        String json = JsonUtils.deserializer(map);
        BaseUser user = JsonUtils.serializable(json, BaseUser.class);
        return user;
    }

}
