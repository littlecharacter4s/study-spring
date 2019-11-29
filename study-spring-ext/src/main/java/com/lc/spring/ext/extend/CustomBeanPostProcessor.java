package com.lc.spring.ext.extend;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.containsIgnoreCase(beanName, "extendService")) {
            System.out.println("CustomBeanPostProcessor：postProcessBeforeInitialization...");
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.containsIgnoreCase(beanName, "extendService")) {
            System.out.println("CustomBeanPostProcessor：postProcessAfterInitialization...");
        }
        return bean;
    }
}
