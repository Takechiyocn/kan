package aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "aop.entities", basePackageClasses = {aop.interfaces.IBuy.class})
public class AppConfig {
//    @Bean
//    public Boy boy() {
//        return new Boy();
//    }
//
//    @Bean
//    public Girl girl() {
//        return  new Girl();
//    }
}
