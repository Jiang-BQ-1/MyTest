package com.example.mytest.Response;

import com.example.mytest.Result.Result;
import com.example.mytest.enmus.ResultEnum;

/**
 * @Classname Response
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/21 18:03
 * @Created by JiangBingQing
 */
public class Response {

    private static final Boolean SUCCESS = true;

    private static final Boolean FAIL = false;

    public static<T> Result<T> ok(){
        return new Result<T>().setCode(ResultEnum.SUCCESS).setSuccess(SUCCESS);
    }

    public static<T> Result<T> ok(ResultEnum resultEnum){
        return new Result<T>().setCode(resultEnum.SUCCESS).setSuccess(SUCCESS).setMessage(resultEnum.getMessage());
    }

    public static<T> Result<T> ok(T data){
        return new Result<T>().setCode(ResultEnum.SUCCESS).setSuccess(SUCCESS).setData(data);
    }

    public static<T> Result<T> ok(String message, T data){
        return new Result<T>().setCode(ResultEnum.SUCCESS).setSuccess(SUCCESS).setMessage(message).setData(data);
    }

    public static<T> Result<T> error(){
        return new Result<T>().setCode(ResultEnum.ERROR).setSuccess(FAIL);
    }

    public static<T> Result<T> error(ResultEnum resultEnum){
        return new Result<T>().setCode(resultEnum.ERROR).setSuccess(FAIL).setMessage(resultEnum.getMessage());
    }

    public static<T> Result<T> error(String message){
        return new Result<T>().setCode(ResultEnum.ERROR).setSuccess(FAIL).setMessage(message);
    }

    public static<T> Result<T> error(ResultEnum resultEnum, String message){
        return new Result<T>().setCode(ResultEnum.ERROR).setSuccess(FAIL).setMessage(message);
    }

    public static<T> Result<T> ok(T data, String message){
        return new Result<T>().setCode(ResultEnum.SUCCESS).setSuccess(SUCCESS).setData(data).setMessage(message);
    }

}
