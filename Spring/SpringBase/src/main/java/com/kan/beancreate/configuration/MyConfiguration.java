package com.kan.beancreate.configuration;

import com.kan.beancreate.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyConfiguration
 * @Description
 * @Author moku
 * @Date 2022/12/10 2:04
 * @Version 1.0
 */
@Configuration
public class MyConfiguration {
    @Bean
    public Customer myCustomer() {
        return new Customer("冯宝宝", 120);
    }
}
