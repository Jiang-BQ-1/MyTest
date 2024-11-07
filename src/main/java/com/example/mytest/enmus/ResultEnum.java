package com.example.mytest.enmus;

/**
 * @Classname ResultEnum
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/21 17:59
 * @Created by JiangBingQing
 */
public enum ResultEnum {
    SUCCESS("200", "成功"),
    ERROR("-1", "失败");

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
