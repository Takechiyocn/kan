package com.kan.beancreate.configuration;

import com.kan.beancreate.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyConfiguration3ComponentScan
 * @Description 3. 基于@Configuration和@Component、@Service、@Controller、@Repository注解方式
 * @Author moku
 * @Date 2022/12/10 2:26
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.kan.beancreate.service.componentscanservice")
public class MyConfiguration3ComponentScan {
    @Bean
    public Customer customerConfigurationBean() {
        return new Customer("张怀义", 149);
    }
}
