package com.itbin.springcloudoauth.user.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.itbin.springcloudoauth.user.data.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LIBIN on 2018/11/17 1:49
 * Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto<T> {

    @Builder.Default
    private Boolean isSuccess = Boolean.TRUE;
    @Builder.Default
    private String code = ResultEnum.SUCCESS.getCode();
    @Builder.Default
    private String message = ResultEnum.SUCCESS.getName();
    private  T data;
}