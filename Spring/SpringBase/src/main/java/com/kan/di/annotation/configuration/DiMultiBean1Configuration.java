package com.kan.di.annotation.configuration;

import com.kan.di.annotation.service.DiMultiBean1Service1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName DiMultiBean1Configuration
 * @Description
 * @Author moku
 * @Date 2022/12/11 22:04
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.kan.di.annotation.service")
public class DiMultiBean1Configuration {

    // DiMultiBean1Service1:未注解成Bean
    // DiMultiBean1Service2:通过Service注解成Bean
    // DiMultiBean1Service1类型Bean：Bean名=t1
    @Bean("t1")
    public DiMultiBean1Service1 t1() {
        return new DiMultiBean1Service1();
    }

    // DIMultiBean1Service1类型Bean：Bean名=t2
    @Bean("t2")
    public DiMultiBean1Service1 t2() {
        return new DiMultiBean1Service1();
    }

    @Bean
    public DiMultiBean1Service1 diMultiBean1Service1() {
        return new DiMultiBean1Service1();
    }
}
