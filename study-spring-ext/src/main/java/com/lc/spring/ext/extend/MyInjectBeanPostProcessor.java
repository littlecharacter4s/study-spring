package com.lc.spring.ext.extend;

import com.lc.spring.ext.annotation.MyInject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MyInjectBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 获取 bean 所有属性字段
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 字段是否被 @MyInject 修饰
            if (field.isAnnotationPresent(MyInject.class)) {
                MyInject annotation = field.getAnnotation(MyInject.class);
                // 获取注解属性
                // String value = annotation.value();
                // 获取字段名和类型
                String name = field.getName();
                Class<?> type = field.getType();
                field.setAccessible(true);
                // TODO: 2023/5/6 通过动态代理来获取对象，这里简便起见直接 new 个对象
                try {
                    Object obj;
                    if (beanFactory.containsBeanDefinition(name)) {
                        obj = beanFactory.getBean(name);
                    } else {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(type);
                        BeanDefinition definition = builder.getBeanDefinition();
                        beanFactory.registerBeanDefinition(name, definition);
                        obj = type.newInstance();
                        beanFactory.registerSingleton(name, obj);
                    }
                    field.set(bean, obj);
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }
}
