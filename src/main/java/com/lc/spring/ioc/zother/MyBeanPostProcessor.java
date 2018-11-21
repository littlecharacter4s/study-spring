package com.lc.spring.ioc.zother;

import com.lc.spring.ioc.service.LifecycleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleService) {
            System.out.println("LifecycleServiceImpl BeanPostProcessor#postProcessBeforeInitialization...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleService) {
            System.out.println("LifecycleServiceImpl BeanPostProcessor#postProcessAfterInitialization...");
        }
        return bean;
    }
}
