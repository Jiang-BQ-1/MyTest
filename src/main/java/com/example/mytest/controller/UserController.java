package com.example.mytest.controller;

import com.example.mytest.customAnnotations.HasRolesAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @HasRolesAnnotation("user")
    @GetMapping("/addUser")
    public String addUser(){
        return "执行新增方法";
    }

    @HasRolesAnnotation("admin")
    @GetMapping("/deleteUser")
    public String deleteUser(){
        return "执行删除方法";
    }

    @GetMapping("/queryUser")
    public String queryUser(){
        return "执行查询方法";
    }
}
