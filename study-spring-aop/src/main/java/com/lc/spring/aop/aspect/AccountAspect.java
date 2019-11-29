package com.lc.spring.aop.aspect;

import com.lc.spring.aop.annotation.Monitor;
import com.lc.spring.aop.base.SpringFactory;
import com.lc.spring.aop.monitor.AccountMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {
    //切入点
    @Pointcut(value = "@annotation(com.lc.spring.aop.annotation.Monitor)")
    private void pointcut() {}

    @Around(value = "pointcut() && @annotation(monitor)")
    public Object around(ProceedingJoinPoint joinPoint, Monitor monitor) {
        String observerName = monitor.value();
        AccountMonitor accountMonitor = (AccountMonitor) SpringFactory.getBean(observerName);
        if (accountMonitor == null) {
            System.out.println("around:监视器为空!");
            return null;
        }
        return accountMonitor.adjust(joinPoint);
    }
}
