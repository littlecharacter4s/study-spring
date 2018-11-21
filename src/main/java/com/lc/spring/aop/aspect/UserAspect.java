package com.lc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    @Pointcut("execution(public * com.lc.spring.aop.service.UserService.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void logBefore() {
        System.out.println("UserAspect logBefore...");
    }
    @After("execution(public * com.lc.spring.aop.service.UserService.addUser(..))")
    public void logAfter() {
        System.out.println("UserAspect logAfter...");
    }
    @AfterReturning("pointcut()")
    public void logReturn() {
        System.out.println("UserAspect logReturn...");
    }
    @AfterThrowing("pointcut()")
    public void logException() {
        System.out.println("UserAspect logException...");
    }
    @Around(("pointcut()"))
    public Object logProceed(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("UserAspect logProceed...");
        return joinPoint.proceed();
    }
}
