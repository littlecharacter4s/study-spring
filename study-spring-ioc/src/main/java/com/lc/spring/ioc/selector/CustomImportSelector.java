package com.lc.spring.ioc.selector;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{StringUtils.class.getCanonicalName()};
    }
}