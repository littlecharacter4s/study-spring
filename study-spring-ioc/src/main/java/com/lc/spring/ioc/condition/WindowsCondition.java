package com.lc.spring.ioc.condition;

import com.lc.spring.ioc.util.PropertyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String property = PropertyUtil.getPropertyBykey("osx.name");
		if (StringUtils.containsIgnoreCase(property, "Windows")) {
			return true;
		}
		return false;
	}

}
