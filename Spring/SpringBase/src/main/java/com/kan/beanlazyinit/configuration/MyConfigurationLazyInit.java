package com.kan.beanlazyinit.configuration;

import com.kan.beanlazyinit.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName MyConfiguration
 * @Description
 * @Author moku
 * @Date 2022/12/10 22:36
 * @Version 1.0
 */
@Configuration
public class MyConfigurationLazyInit {
    @Bean
    public Customer customerDefault() {
        // 无参构造
        return new Customer();
    }

    @Lazy
    @Bean
    public Customer customerLazyInit() {
        return new Customer("张楚岚", 21);
    }
}
