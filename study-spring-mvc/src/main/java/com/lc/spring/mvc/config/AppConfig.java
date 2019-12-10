package com.lc.spring.mvc.config;

import com.lc.spring.mvc.interceptor.GlobalInterceptor;
import com.lc.spring.mvc.interceptor.SpecialInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.lc.spring.mvc",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters = false
)
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry.jsp("/views/", ".html");
        registry.freeMarker().prefix("/views/").suffix(".html").cache(false);;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException {
        // Configure FreeMarker...
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();

        // configurer.setTemplateLoaderPath("/views/");
        // Properties properties = new Properties();
        // properties.setProperty("template_update_delay", "0");
        // properties.setProperty("default_encoding", "UTF-8");
        // properties.setProperty("number_format", "0.##########");
        // properties.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        // properties.setProperty("classic_compatible", "true");
        // properties.setProperty("template_exception_handler", "ignore");
        // configurer.setFreemarkerSettings(properties);

        return configurer;
    }
//
//     @Bean
//     public FreeMarkerViewResolver freeMarkerViewResolver() {
//         FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
//         viewResolver.setSuffix(".html");
//         viewResolver.setContentType("text/html;charset=UTF-8");
//         return viewResolver;
//     }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new SpecialInterceptor()).addPathPatterns("/springmvc/**").excludePathPatterns("/springmvc/test/**");
    }

    //静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}





























