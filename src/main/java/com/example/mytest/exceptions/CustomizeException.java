package com.example.mytest.exceptions;

import com.example.mytest.enmus.ResultEnum;

/**
 * @Classname customizeException
 * @Description 自定义异常
 * @Version 1.0.0
 * @Date 2024/10/21 19:13
 * @Created by JiangBingQing
 */
public class CustomizeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //异常编码
    private String code;

    /**
    * @Author: JiangBingQing
    * @Description: 自定义异常构造
    * @DateTime: 2024/10/21 19:15
    * @Params: [code, message]
    * @Return 
    */
    public CustomizeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CustomizeException(String message){
        super(message);
        this.code = ResultEnum.ERROR.getCode();
    }
}
