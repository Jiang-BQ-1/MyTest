package com.example.mytest.vo;

import com.example.mytest.common.DateJsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private String name;
    private Integer age;
    //如果birthday为null，则返回DateJsonSerialize中填写的默认值
//    @JsonSerialize(nullsUsing = DateJsonSerialize.class)
    //直接使用DateJsonSerialize中的默认值
    @JsonSerialize(using = DateJsonSerialize.class)
    private Date birthday;
}
