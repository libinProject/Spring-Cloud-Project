package com.itbin.springcloudoauth.authorization.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.itbin.springcloudoauth.authorization.data.eums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LIBIN on 2018/11/17 2:17
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