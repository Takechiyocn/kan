package com.kan.di.annotation.configuration;

import com.kan.di.annotation.service4.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConfig
 * @Description
 * @Author moku
 * @Date 2022/12/12 10:32
 * @Version 1.0
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new UserFilter());
        bean.addUrlPatterns("/f/*");
        return bean;
    }
}
