package com.example.mytest.aspect;

import com.example.mytest.service.IMaterialEamLogService;
import com.example.mytest.vo.MaterialEamLogVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Classname SysLogAspect
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 18:03
 * @Created by JiangBingQing
 */
@Aspect
@Component
@SuppressWarnings("all")
@Slf4j
public class SysLogAspect {

    @Autowired
    private IMaterialEamLogService materialEamLogService;

    @Pointcut("@annotation(com.example.mytest.customAnnotations.RequiredLogAnnotations) ")
    public void logPointCut() {
        log.info("记录日志");
    }

    @Around("logPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        long startTime = System.currentTimeMillis();
        log.info("开始记录日志："+startTime);
        try {
            result = joinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            log.info("结束记录日志 "+endTime);
            log.info("耗时：" + (endTime - startTime));
            saveLog(joinPoint, result, String.valueOf(endTime - startTime));
        }
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, Object result, String time) {

        //获取用户行为日志（ip、usernamme、method。。。。。。）
        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> aClass = joinPoint.getTarget().getClass();

        //获取方法签名（通过此签名获取目标方法消息）
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //通过类对象获取类名
        String className = aClass.getName();

        String targetObjectMethod = className +"."+signature.getName();

        //获取请求参数
        String params = Arrays.toString(joinPoint.getArgs());

        String url = "";
        String ipAddress = "";

        if(RequestContextHolder.getRequestAttributes() != null){

            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            url = request.getRequestURI();
            ipAddress = request.getRemoteAddr();
        }

        MaterialEamLogVo materialEamLogVo = new MaterialEamLogVo();
        materialEamLogVo.setParams(params);
        materialEamLogVo.setMethod(targetObjectMethod);
        materialEamLogVo.setUrl(url);
        materialEamLogVo.setIp(ipAddress);
        materialEamLogVo.setResult(String.valueOf(result));
        materialEamLogVo.setTime(time);
        materialEamLogService.insert(materialEamLogVo);
    }
}
