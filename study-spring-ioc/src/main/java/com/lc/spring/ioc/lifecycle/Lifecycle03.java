package com.lc.spring.ioc.lifecycle;

import com.lc.spring.ioc.config.CommonConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Lifecycle03 implements InitializingBean, DisposableBean, ApplicationContextAware {
    private CommonConfig commonConfig;
    private ApplicationContext applicationContext;

    public Lifecycle03() {
        System.out.println("Lifecycle03：实例化...");
    }

    @Resource
    public void setCommonConfig(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
        System.out.println("Lifecycle03：设属性...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Lifecycle03：设属性ApplicationContext...");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("Lifecycle03：postConstruct...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Lifecycle03：设属性后...");
    }

    public void initBean() throws Exception {
        System.out.println("Lifecycle03：初始化...");
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("Lifecycle03：preDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Lifecycle03：销毁（destroy）...");
    }

    public void destroyBean() throws Exception {
        System.out.println("Lifecycle03：销毁（destroyBean）...");
    }
}
