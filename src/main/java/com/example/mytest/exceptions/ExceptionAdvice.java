package com.example.mytest.exceptions;

import com.example.mytest.Response.Response;
import com.example.mytest.Result.Result;
import com.example.mytest.enmus.ResultEnum;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @Classname ExceptionAdvice
 * @Description 全局异常捕获
 * @Version 1.0.0
 * @Date 2024/10/20 0:02
 * @Created by JiangBingQing
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 单个参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleValidationException(ConstraintViolationException e){

        for(ConstraintViolation<?> s: e.getConstraintViolations()){
            return Response.error(ResultEnum.ERROR, s.getMessage());
        }
        return Response.error("未知的参数错误");
    }

    /**
     * 方法参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationMethodException(MethodArgumentNotValidException e){

        for (ObjectError s : e.getBindingResult().getAllErrors()) {
            return Response.error(ResultEnum.ERROR, s.getDefaultMessage());
        }
        return Response.error(ResultEnum.ERROR, "未知的参数错误");
    }

    /**
    * @Author: JiangBingQing
    * @Description: 处理自定义异常
    * @DateTime: 2024/10/21 19:28
    * @Params: [e]
    * @Return com.example.mytest.Result.Result
    */
    @ExceptionHandler(CustomizeException.class)
    public Result handleMyException(CustomizeException e){
        e.printStackTrace();
        return Response.error(ResultEnum.ERROR, e.getMessage());
    }

    /**
    * @Author: JiangBingQing
    * @Description: 默认全局异常捕获
    * @DateTime: 2024/10/21 19:11
    * @Params: [e]
    * @Return com.example.mytest.Result.Result
    */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        return Response.error(ResultEnum.ERROR, e.getMessage());
    }

}
