package com.kan.beancreate.configuration;

import com.kan.beancreate.entity.Customer;
import com.kan.beancreate.service.MyConfiguration6ImportBeanDefinitionRegistrarImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName MyConfigurationImportBeanDefinitionRegistrar
 * @Description
 * @Author moku
 * @Date 2022/12/10 13:56
 * @Version 1.0
 */
@Configuration
@Import({MyConfiguration6ImportBeanDefinitionRegistrarImpl.class})
public class MyConfiguration6ImportBeanDefinitionRegistrar {
    @Bean
    public Customer customerBeanDefinitionRegistrar() {
        return new Customer("无根生", 124);
    }
}
