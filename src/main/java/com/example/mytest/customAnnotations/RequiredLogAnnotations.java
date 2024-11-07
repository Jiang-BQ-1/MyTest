package com.example.mytest.customAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname RequiredLogAnnotations
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 18:02
 * @Created by JiangBingQing
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
@Documented
public @interface RequiredLogAnnotations {


}
