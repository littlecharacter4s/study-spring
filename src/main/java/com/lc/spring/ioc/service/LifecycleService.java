package com.lc.spring.ioc.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;

public interface LifecycleService extends InitializingBean, DisposableBean, ApplicationContextAware {
}
