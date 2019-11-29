package com.lc.spring.aop.monitor;

import com.lc.spring.aop.pojo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class OrderIncomeMonitor implements AccountMonitor {
    @Override
    public Object adjust(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("OrderIncomeMonitor：处理订单收入之前...");
            Object o = joinPoint.proceed();
            Result result = (Result) o;
            if (result.isSuccess()) {
                System.out.println("OrderIncomeMonitor：处理订单收入之后...");
            } else {
                System.out.println("OrderIncomeMonitor：处理订单收入之后...");
            }
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
