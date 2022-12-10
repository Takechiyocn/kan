package com.kan.beancreate.test;

import com.kan.beancreate.configuration.MyConfiguration3ComponentScan;
import com.kan.beancreate.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoadBeanBy3ConfigurationComponent
 * @Description 生成Bean方法：1. 基于XML配置
 *                          2. 基于@Configuration+@Bean的形式
 *                          3. 基于@Configuration+@Component/@Service/@Controller/@Repository注解方式
 *                          4. 基于@Configuration+@Import注解方式
 *                          5. 基于@Configuration+@Import注解和ImportSelector接口方式
 *                          6. 基于@Configuration+@Import注解和ImportBeanDefinitionRegistrar接口方式
 *                          7. 基于@Configuration+@Component注解方式和实现FactoryBean接口方式
 *                          8. 基于@Configuration+@Conditional注解(Spring4注解)+实现Condition接口方式
 * @Author moku
 * @Date 2022/12/10 2:30
 * @Version 1.0
 */
public class LoadBeanBy3ConfigurationComponent {
    /**
     * 测试配置文件中指定扫描包路径的方式创建Bean
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration3ComponentScan.class);
        Customer bean1 = (Customer) context.getBean("customerConfigurationBean");
        Customer bean2 = (Customer) context.getBean("customerScannedComponent");
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
