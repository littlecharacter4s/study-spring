package com.lc.spring.ioc;

import com.alibaba.fastjson.JSONObject;
import com.lc.spring.ioc.service.impl.LifecycleServiceImpl;
import com.lc.spring.ioc.zother.MyImportBeanDefinitionRegistrar;
import com.lc.spring.ioc.zother.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.lc.spring.ioc") // 自己代码里的组件
@Import({
        JSONObject.class, // 第一种方式
        MyImportSelector.class, // 第二种方式
        MyImportBeanDefinitionRegistrar.class // 第三种方式
}) // 导入三方包的组件
public class MainConfig {
    @Bean(value = "lifecycleService",initMethod = "initBean", destroyMethod = "destroyBean")
    public LifecycleServiceImpl lifecycleService(){
        return new LifecycleServiceImpl();
    }
}
