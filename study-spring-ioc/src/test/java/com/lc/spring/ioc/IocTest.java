package com.lc.spring.ioc;

import com.alibaba.fastjson.JSON;
import com.lc.spring.ioc.base.SpringFactory;
import com.lc.spring.ioc.component.UserServiceImpl;
import com.lc.spring.ioc.config.CommonConfig;
import com.lc.spring.ioc.service.SystemService;
import com.lc.spring.ioc.service.TradeService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IocTest {
    @Test
    public void testIoc() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig.class);
        String[] definitionBeans = applicationContext.getBeanDefinitionNames();
        System.out.println("-------------------------------------------------------------------------------");
        Arrays.stream(definitionBeans).forEach(System.out::println);
        System.out.println("--------------");
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.getUserName(1234567890L));
        TradeService tradeService = (TradeService) applicationContext.getBean("tradeService");
        System.out.println(tradeService.getItemInfo(1234567890L));
        SystemService systemService = (SystemService) applicationContext.getBean("systemService");
        System.out.println(systemService.hello());
        System.out.println(applicationContext.getBean("customFactoryBean"));
        System.out.println(applicationContext.getBean("&customFactoryBean"));
        CommonConfig commonConfig = (CommonConfig) applicationContext.getBean("commonConfig");
        System.out.println(JSON.toJSON(commonConfig));
        commonConfig = (CommonConfig) SpringFactory.getBean("commonConfig");
        System.out.println(JSON.toJSON(commonConfig));
        System.out.println("------------------");
        System.out.println("Spring：容器关闭...");
        applicationContext.close();
    }
}