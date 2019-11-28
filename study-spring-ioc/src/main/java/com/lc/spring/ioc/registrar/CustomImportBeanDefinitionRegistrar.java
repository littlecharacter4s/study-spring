package com.lc.spring.ioc.registrar;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 要注册的类必须有默认的空构造方法
        RootBeanDefinition beanDefinition = new RootBeanDefinition(NumberUtils.class);
        registry.registerBeanDefinition("numberUtils", beanDefinition);
    }
}
