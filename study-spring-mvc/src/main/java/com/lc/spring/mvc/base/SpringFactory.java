package com.lc.spring.mvc.base;

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
        return applicationContext.getBean(type);
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
