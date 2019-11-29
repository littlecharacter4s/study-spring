package com.lc.spring.aop.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private SpringFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringFactory.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> type) {
        return type == null ? null : applicationContext.getBean(type);
    }

    public static Object getBean(String name) {
        return StringUtils.isEmpty(name) ? null : applicationContext.getBean(name);
    }
}
