package com.lc.spring.ioc.postprocessor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.containsIgnoreCase(beanName, "Lifecycle") || Objects.equals(beanName, "springFactory")) {
            System.out.println("CustomBeanPostProcessor：postProcessBeforeInitialization...");
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.containsIgnoreCase(beanName, "Lifecycle") || Objects.equals(beanName, "springFactory")) {
            System.out.println("CustomBeanPostProcessor：postProcessAfterInitialization...");
        }
        return bean;
    }
}
