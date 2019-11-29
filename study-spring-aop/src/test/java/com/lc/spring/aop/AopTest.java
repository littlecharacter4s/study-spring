package com.lc.spring.aop;

import com.lc.spring.aop.service.AccountService;
import com.lc.spring.aop.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AopTest {
    @Test
    public void testAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionBeans).forEach(System.out::println);
        System.out.println("---------------------------");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.getOrederInfo(1234567890L);
        // System.out.println("---------------------------");
        // orderService.getOrederInfo(0L);
        System.out.println("-------------------------------------");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.handleOrderIncome(1234567890L, 27L);
        accountService.handleBonusImport(1234567890L, 27L);
        System.out.println("---------------------------------");
        accountService.handleOrderIncome(); //aop的原理是动态代理，这里没有用到代理类，而是用this，所以监控不到
        applicationContext.close();
    }

}