package com.lc.spring.tx;

import com.alibaba.fastjson.JSON;
import com.lc.spring.tx.entity.User;
import com.lc.spring.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
    @Test
    public void testTx() {
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.getUserInfo(1234567890L);
        System.out.println(JSON.toJSONString(user));
        System.out.println("--------------------------");
        user.setId(9876543210L);
        user.setIdNumber("202020199009243235");
        int result = userService.addUser(user);
        System.out.println("add user " + (result == 1 ? "success" : "fail"));
        applicationContext.close();
    }
}