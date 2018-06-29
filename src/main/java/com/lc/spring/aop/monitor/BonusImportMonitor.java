package com.lc.spring.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class BonusImportMonitor implements AccountMonitor {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            Object o = joinPoint.proceed();
            System.out.println("BonusImportMonitor:奖金导入调整!!!");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
