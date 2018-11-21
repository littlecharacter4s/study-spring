package com.lc.spring.tx;

import com.alibaba.fastjson.JSON;
import com.lc.spring.tx.service.DrawService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionBeans).forEach(System.out::println);
        DrawService service = applicationContext.getBean(DrawService.class);
        System.out.println(JSON.toJSONString(service.getDraw(1L)));
        applicationContext.close();
    }
}
