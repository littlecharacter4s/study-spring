package com.lc.spring.ioc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:common.properties"})
public class CommonConfig {
    @Value("${osx.name}")
    public String osxName;

    public String getOsxName() {
        return osxName;
    }

    public void setOsxName(String osxName) {
        this.osxName = osxName;
    }
}
