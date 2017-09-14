package com.sweet.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:sweet
 * @Date:2017-8-15 15:06:02
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //@Before("execution(public * com.sweet.controller.StudentController.queryStudentList(..))")
   /* @Before("execution(public * com.sweet.controller.StudentController.*(..))")
    public void logBefore(){
        System.out.println("开始访问StudentControllerl里面的方法：");
    }

    @After("execution(public * com.sweet.controller.StudentController.*(..))")
    public void logAfter(){
        System.out.println("访问结束！！");
    }*/

    @Pointcut("execution(public * com.sweet.controller.StudentController.queryStudentList(..))")
    public void log() {
    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint) {
        //记录http请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类.方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void logAfter() {
        logger.info("访问结束！！");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void logAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
