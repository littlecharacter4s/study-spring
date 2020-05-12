package com.lc.spring.ext.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CustomSmartInitializingSingleton implements SmartInitializingSingleton, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        // 在所有的 bean 都初始化好之后（也就是 bean 都在 singletonObjects 中了）调用，@EventListener 使用了这种方式
        System.out.println("CustomSmartInitializingSingleton：afterSingletonsInstantiated...");
    }
}
