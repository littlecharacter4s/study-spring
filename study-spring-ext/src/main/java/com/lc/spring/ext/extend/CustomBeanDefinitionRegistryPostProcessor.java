package com.lc.spring.ext.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("CustomBeanDefinitionRegistryPostProcessor#postProcessBeanFactory：当前BeanFactory中定义了" + beanFactory.getBeanDefinitionCount() + "个Bean");
    }

    //BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("CustomBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry：当前BeanFactory中定义了" + registry.getBeanDefinitionCount() + "个Bean");
        //RootBeanDefinition beanDefinition = new RootBeanDefinition(Random.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Random.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }
}
