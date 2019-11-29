package com.lc.spring.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class BonusImportMonitor implements AccountMonitor {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("BonusImportMonitor：处理奖金导入之前...");
            Object o = joinPoint.proceed();
            System.out.println("BonusImportMonitor：处理奖金导入之后...");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
