package com.lc.spring.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomFactoryBean implements FactoryBean<Random> {
    @Override
    public Random getObject() throws Exception {
        return new Random();
    }

    @Override
    public Class<?> getObjectType() {
        return Random.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
