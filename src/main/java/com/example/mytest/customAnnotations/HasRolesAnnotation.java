package com.example.mytest.customAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(java.lang.annotation.ElementType.METHOD)
public @interface HasRolesAnnotation {

    String value() default "";
}
