package com.kan.beancreate.service;

import com.kan.beancreate.entity.Address;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyConfiguration6ImportBeanDefinitionRegistrarImpl
 * @Description 1. ImportBeanDefinitionRegistrar能够实现动态注册bean到容器中
 *              2. 实现自定义注解，让Spring扫描带有指定注解的类，
 *                 通过Spring核心容器(SpringCore)的BeanFactory创建出这个Bean并将其添加到Spring容器中
 * @Author moku
 * @Date 2022/12/10 14:00
 * @Version 1.0
 */
public class MyConfiguration6ImportBeanDefinitionRegistrarImpl implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 如果存在customer对象，则再加载一个myAddress
        if (registry.containsBeanDefinition("customerBeanDefinitionRegistrar")) {
            registry.registerBeanDefinition("myAddress",new RootBeanDefinition(Address.class));
        }
    }
}
