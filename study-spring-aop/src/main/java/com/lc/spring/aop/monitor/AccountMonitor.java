package com.lc.spring.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AccountMonitor {
    Object adjust(ProceedingJoinPoint joinPoint);
}
