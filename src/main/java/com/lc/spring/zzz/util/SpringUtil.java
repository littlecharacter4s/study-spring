package com.lc.spring.zzz.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class SpringUtil {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

    private SpringUtil(){}

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
        }
        return applicationContext;
    }

    public static <T> T getBean(Class<T> type) {
        if (type == null) {
            return null;
        }
        return applicationContext.getBean(type);
    }

    public static Object getBean(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return applicationContext.getBean(name);
    }
}
