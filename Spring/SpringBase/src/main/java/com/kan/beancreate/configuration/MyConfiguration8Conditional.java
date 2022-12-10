package com.kan.beancreate.configuration;

import com.kan.beancreate.entity.Customer;
import com.kan.beancreate.service.MyConfiguration8ConditionalImpl;
import com.kan.beancreate.service.MyConfiguration8ConditionalImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName MyConfiguration8Conditional
 * @Description
 * @Author moku
 * @Date 2022/12/10 17:10
 * @Version 1.0
 */
@Configuration
@PropertySource("myApplication.properties")
public class MyConfiguration8Conditional {
    @Bean
    @Conditional(MyConfiguration8ConditionalImpl.class)
    public Customer customerConditional() {
        return new Customer("张楚岚", 21);
    }

    @Bean
    @Conditional(MyConfiguration8ConditionalImpl2.class)
    public Customer customerConditional2() {
        return new Customer("冯宝宝", 18);
    }
}
