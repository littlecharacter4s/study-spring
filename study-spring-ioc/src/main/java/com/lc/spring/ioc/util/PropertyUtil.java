package com.lc.spring.ioc.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public final class PropertyUtil {
    private Properties properties;

    private PropertyUtil() {
        properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(ResourceUtils.getFile("classpath:common.properties"));
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PropertyUtilInner {
        private static final PropertyUtil propertiesUtil = new PropertyUtil();

        private PropertyUtilInner() {
        }
    }

    private static PropertyUtil getSingletonInstance() {
        return PropertyUtilInner.propertiesUtil;
    }

    private String getProperty(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        return Optional.ofNullable(properties.getProperty(key)).orElse("");
    }

    public static String getPropertyBykey(String key){
        return PropertyUtil.getSingletonInstance().getProperty(key);
    }
}
