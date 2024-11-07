package com.example.mytest.Result;

import com.example.mytest.enmus.ResultEnum;

/**
 * @Classname Result
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/21 17:46
 * @Created by JiangBingQing
 */
public class Result <T>{

    //返回内容
    private T Data;

    //返回消息
    private String Message;

    //返回消息编码
    private String Code;

    private Boolean Success;


    public T getData() {
        return Data;
    }

    public Result<T> setData(T data) {
        this.Data = data;
        return this;
    }

    public String getMessage() {
        return Message;
    }

    public Result<T> setMessage(String message) {
        this.Message = message;
        return this;
    }

    public String getCode() {
        return Code;
    }

    public Result<T> setCode(ResultEnum resultEnum) {
        this.Code = resultEnum.getCode();
        return this;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public Result<T> setSuccess(Boolean success) {
        this.Success = success;
        return this;
    }
}
