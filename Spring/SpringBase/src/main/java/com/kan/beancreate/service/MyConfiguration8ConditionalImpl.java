package com.kan.beancreate.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MyConfiguration8ConditionalImpl
 * @Description 当满足什么条件时才给Spring容器注册Bean
 * @Author moku
 * @Date 2022/12/10 21:26
 * @Version 1.0
 */
public class MyConfiguration8ConditionalImpl implements Condition {

    /**
     * 当配置文件中包含有配置security.isOpen并且配置文件的值为true时才向Spring中注入Bean
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        if (environment.containsProperty("security.isOpen") &&
                environment.getProperty("security.isOpen").equals("true")) {
            return true;
        }
        return false;
    }
}
