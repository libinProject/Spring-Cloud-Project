package com.itbin.springcloudoauth.authjwt.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.itbin.springcloudoauth.authjwt.data.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LIBIN on 2018/11/19 14:46
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
