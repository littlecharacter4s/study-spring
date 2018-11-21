package com.lc.spring.ioc.zother;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 要注册的类必须有默认的空构造方法
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Arrays.class);
        registry.registerBeanDefinition("arrays", beanDefinition);
    }
}
