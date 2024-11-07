package com.example.mytest.aspect;

import com.example.mytest.cache.CacheManager;
import com.example.mytest.customAnnotations.HasRolesAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class UserRolesAspect {

    @Pointcut("@annotation(com.example.mytest.customAnnotations.HasRolesAnnotation)")
    public void pointcut(){
        System.out.println("pointcut");
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){

        // 通过RequestContextHolder获取ServletRequestAttributes对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 通过ServletRequestAttributes对象获取HttpServletRequest对象
        HttpServletRequest request = attributes.getRequest();
        String username = request.getParameter("username");
        // 从缓存中获取用户角色
        List<String> list = CacheManager.User_Roles.get(username);
        // 获取方法
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        // 通过反射获取方法对象
        Method method = signature.getMethod();
        // 获取方法上的注解
        HasRolesAnnotation hasRoles = method.getAnnotation(HasRolesAnnotation.class);
        // 判断是否包含注解
        if(hasRoles != null && (list == null || !list.contains(hasRoles.value()))){
            throw new RuntimeException("用户没有权限");
        }

    }
}
