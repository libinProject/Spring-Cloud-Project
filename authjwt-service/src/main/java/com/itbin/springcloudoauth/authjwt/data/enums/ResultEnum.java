package com.itbin.springcloudoauth.authjwt.data.enums;

/**
 * Created by LIBIN on 2018/11/19 14:47
 * Description:
 */
public enum ResultEnum {

    SUCCESS("操作成功","100"),
    OTHER_ERROR("未知错误,请联系管理员","102"),
    DATE_FORMAT_ERROR("日期转换异常","103");

    private String name;
    private String code;

    ResultEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
