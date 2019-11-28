package com.lc.spring.ioc.lifecycle;

import com.lc.spring.ioc.config.CommonConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

public class Lifecycle02 implements InitializingBean, DisposableBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private CommonConfig commonConfig;

    public Lifecycle02() {
        System.out.println("Lifecycle02：实例化...");
    }

    @Resource
    public void setCommonConfig(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
        System.out.println("Lifecycle02：设属性...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Lifecycle02：设属性ApplicationContext...");
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Lifecycle02：设属性后...");
    }

    public void initBean() throws Exception {
        System.out.println("Lifecycle02：初始化...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Lifecycle02：销毁（destroy）...");
    }

    public void destroyBean() throws Exception {
        System.out.println("Lifecycle02：销毁（destroyBean）...");
    }
}
