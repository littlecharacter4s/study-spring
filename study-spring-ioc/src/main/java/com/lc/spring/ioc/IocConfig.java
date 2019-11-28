package com.lc.spring.ioc;

import com.alibaba.fastjson.JSONObject;
import com.lc.spring.ioc.component.UserServiceImpl;
import com.lc.spring.ioc.condition.LinuxCondition;
import com.lc.spring.ioc.condition.WindowsCondition;
import com.lc.spring.ioc.lifecycle.Lifecycle01;
import com.lc.spring.ioc.lifecycle.Lifecycle02;
import com.lc.spring.ioc.lifecycle.Lifecycle03;
import com.lc.spring.ioc.registrar.CustomImportBeanDefinitionRegistrar;
import com.lc.spring.ioc.selector.CustomImportSelector;
import com.lc.spring.ioc.service.impl.LinuxSystemServiceImpl;
import com.lc.spring.ioc.service.impl.WindowsSystemServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.lc.spring.ioc")
//@ComponentScan(value = "com.lc.spring.ioc", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {CustomTypeFilter.class})}, useDefaultFilters = false)
//@ComponentScan(value = "com.lc.spring.ioc", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, useDefaultFilters = false)
//@ComponentScan(value = "com.lc.spring.ioc", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, useDefaultFilters = false)
//@Conditional({LinuxCondition.class})
@Import({
        JSONObject.class, // 第一种方式
        CustomImportSelector.class, // 第二种方式
        CustomImportBeanDefinitionRegistrar.class // 第三种方式
}) // 导入三方包的组件
public class IocConfig {
    @Lazy
    //@Scope("prototype")
    @Bean("userService")
    public UserServiceImpl userServiceX() {
        return new UserServiceImpl();
    }

    @Bean("systemService")
    @Conditional({LinuxCondition.class})
    public LinuxSystemServiceImpl linuxSystemService() {
        return new LinuxSystemServiceImpl();
    }

    @Bean("systemService")
    @Conditional({WindowsCondition.class})
    public WindowsSystemServiceImpl windowsSystemService() {
        return new WindowsSystemServiceImpl();
    }

    @Bean(value = "lifecycle01", initMethod = "init", destroyMethod = "destroy")
    public Lifecycle01 lifecycle01() {
        return new Lifecycle01();
    }

    @Bean(value = "lifecycle02", initMethod = "initBean", destroyMethod = "destroyBean")
    public Lifecycle02 lifecycle02() {
        return new Lifecycle02();
    }

    @Bean(value = "lifecycle03", initMethod = "initBean", destroyMethod = "destroyBean")
    public Lifecycle03 lifecycle03() {
        return new Lifecycle03();
    }
}
