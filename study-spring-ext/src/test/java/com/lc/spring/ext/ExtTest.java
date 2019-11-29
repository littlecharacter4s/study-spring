package com.lc.spring.ext;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ExtTest {
    @Test
    public void testExt() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        System.out.println("-------------------------------------------------------------------------------");
        Arrays.stream(definitionBeans).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------");
        //发布事件；
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });
        applicationContext.close();
    }
}