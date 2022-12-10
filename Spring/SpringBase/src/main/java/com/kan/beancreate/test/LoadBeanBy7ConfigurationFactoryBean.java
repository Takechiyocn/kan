package com.kan.beancreate.test;

import com.kan.beancreate.configuration.MyConfiguration7FactoryBean;
import com.kan.beancreate.entity.Customer;
import com.kan.beancreate.service.factorybeanservice.MyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoadBeanBy7ConfigurationFactoryBean
 * @Description 生成Bean方法：1. 基于XML配置
 *                          2. 基于@Configuration+@Bean的形式
 *                          3. 基于@Configuration+@Component/@Service/@Controller/@Repository注解方式
 *                          4. 基于@Configuration+@Import注解方式
 *                          5. 基于@Configuration+@Import注解和ImportSelector接口方式
 *                          6. 基于@Configuration+@Import注解和ImportBeanDefinitionRegistrar接口方式
 *                          7. 基于@Configuration+@Component注解方式和实现FactoryBean接口方式
 *                          8. 基于@Configuration+@Conditional注解(Spring4注解)+实现Condition接口方式
 * @Author moku
 * @Date 2022/12/10 14:46
 * @Version 1.0
 */
public class LoadBeanBy7ConfigurationFactoryBean {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration7FactoryBean.class);
        // 组件扫描到的bean内通过FactoryBean生成的bean(Customer)
        Object obj = context.getBean("myFactoryBean");
        if (obj instanceof MyFactoryBean) {
            System.out.println((MyFactoryBean)obj);
        }
        if (obj instanceof Customer) {
            System.out.println((Customer)obj);
        }

        System.out.println("----------------------------------");

        // 组件扫描到的bean(包装bean需要用&)
        Object obj2 = context.getBean("&myFactoryBean");
        if (obj2 instanceof MyFactoryBean) {
            System.out.println((MyFactoryBean)obj2);
        }
        if (obj2 instanceof Customer) {
            System.out.println((Customer)obj2);
        }
    }
}
