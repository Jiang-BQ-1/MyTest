package com.example.mytest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.example.mytest.dao")
@EnableWebMvc
public class MyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTestApplication.class, args);
	}

}
