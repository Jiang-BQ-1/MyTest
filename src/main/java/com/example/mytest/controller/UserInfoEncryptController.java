package com.example.mytest.controller;

import com.example.mytest.customAnnotations.RequiredLogAnnotations;
import com.example.mytest.service.IMaterialEamLogService;
import com.example.mytest.vo.StudentVo;
import com.example.mytest.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserInfoEncryptController {

    @Autowired
    private IMaterialEamLogService iMaterialEamLogService;
    @GetMapping("/userInfo")
    public StudentVo getUserInfo() {

        return new StudentVo("张三", 18, new Date());
    }


    @GetMapping("/userInfo2")
    public UserVo getUserInfo2() {
        return iMaterialEamLogService.getUserInfo();
    }

    @GetMapping("/userInfo3")
    @RequiredLogAnnotations
    public String getUserInfo3(String name) throws InterruptedException {
        iMaterialEamLogService.getUserInfo();
        return "hello world";
    }
}
