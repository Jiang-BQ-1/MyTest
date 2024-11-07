package com.example.mytest.customAnnotations;

import com.example.mytest.common.SensitiveJsonSerialize;
import com.example.mytest.enmus.SensitiveStrategyEnum;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
// 这个注解用来标记JackSon为复合注解，当使用多个Jackson注解组合成一个注解的时候，必须加上这个注解
@JacksonAnnotationsInside
// 指定使用自定义的序列化器
@JsonSerialize(using = SensitiveJsonSerialize.class)
public @interface SensitiveAnnotation {
    SensitiveStrategyEnum value();
}
