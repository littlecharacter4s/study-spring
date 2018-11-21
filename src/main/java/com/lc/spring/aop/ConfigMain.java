package com.lc.spring.aop;

import com.alibaba.fastjson.JSON;
import com.lc.spring.aop.service.UserService;
import com.lc.spring.zzz.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionBeans).forEach(System.out::println);
        UserService service = applicationContext.getBean(UserService.class);
        System.out.println(JSON.toJSONString(service.addUser(new User())));
        applicationContext.close();
    }
}
