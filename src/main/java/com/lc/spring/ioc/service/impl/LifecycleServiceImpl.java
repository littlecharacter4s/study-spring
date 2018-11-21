package com.lc.spring.ioc.service.impl;

import com.lc.spring.ioc.service.LifecycleService;
import com.lc.spring.ioc.service.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class LifecycleServiceImpl implements LifecycleService {
    private ApplicationContext applicationContext;
    private OrderService orderService;

    public LifecycleServiceImpl() {
        System.out.println("LifecycleServiceImpl实例化...");
    }

    @Resource
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
        System.out.println("LifecycleServiceImpl设属性...");
    }

    @PostConstruct // 1
    public void postConstruct() throws Exception {
        System.out.println("LifecycleServiceImpl postConstruct...");
    }

    @Override // 2
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleServiceImpl InitializingBean#afterPropertiesSet...");
    }

    // 3
    public void initBean() throws Exception {
        System.out.println("LifecycleServiceImpl initBean...");
    }

    @PreDestroy // 1
    public void preDestroy() throws Exception {
        System.out.println("LifecycleServiceImpl preDestroy...");
    }

    @Override // 2
    public void destroy() throws Exception {
        System.out.println("LifecycleServiceImpl DisposableBean#destroy...");
    }
    // 3
    public void destroyBean() throws Exception {
        System.out.println("LifecycleServiceImpl destroyBean...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("LifecycleServiceImpl setApplicationContext...");
        this.applicationContext = applicationContext;
    }
}
