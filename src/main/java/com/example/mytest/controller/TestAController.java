package com.example.mytest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAController {

    @PostMapping("TestController/testA")
    public String testA(int ABC){
        System.out.println(ABC);

        return "Hello World";
    }
}
