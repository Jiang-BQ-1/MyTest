package com.example.mytest.customAnnotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckTokenAnnotation {

    String [] value() default {};
}
