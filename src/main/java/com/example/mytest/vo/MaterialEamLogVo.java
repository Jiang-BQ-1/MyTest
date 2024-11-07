package com.example.mytest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialEamLogVo {

    //参数
    private String params;
    //方法
    private String method;
    //地址
    private String url;
    //ip
    private String ip;
    //返回结果
    private String result;
    //执行时间
    private String time;
}
