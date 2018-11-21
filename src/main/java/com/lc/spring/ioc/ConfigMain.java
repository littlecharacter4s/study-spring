package com.lc.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.lc.spring.ioc.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Random;

public class ConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionBeans).forEach(System.out::println);
        OrderService service = applicationContext.getBean(OrderService.class);
        System.out.println(JSON.toJSONString(service.getOrder(20181111111111L)));
        Random random = (Random) applicationContext.getBean("myFactoryBean");
        System.out.println(random.nextInt());
        applicationContext.close();
    }
}
