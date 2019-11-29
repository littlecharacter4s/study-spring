package com.lc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {
    @Pointcut("execution(public * com.lc.spring.aop.service.OrderService.*(..))")
    public void pointcut(){}

    @Before("execution(public * com.lc.spring.aop.service.OrderService.getOrederInfo(..))")
    public void logBefore() {
        System.out.println("OrderAspect：before log...");
    }

    @After("pointcut()")
    public void logAfter() {
        System.out.println("OrderAspect：after log...");
    }

    @AfterReturning("pointcut()")
    public void logReturn() {
        System.out.println("OrderAspect：return log...");
    }

    @AfterThrowing("pointcut()")
    public void logException() {
        System.out.println("OrderAspect：exception log...");
    }

    @Around(("pointcut()"))
    public Object logProceed(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("OrderAspect：proceed log...");
        return joinPoint.proceed();
    }
}
