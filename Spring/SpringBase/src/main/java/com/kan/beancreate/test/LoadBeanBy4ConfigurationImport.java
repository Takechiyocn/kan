package com.kan.beancreate.test;

import com.kan.beancreate.configuration.MyConfiguration4Import;
import com.kan.beancreate.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoadBeanBy4ConfigurationImport
 * @Description 生成Bean方法：1. 基于XML配置
 *                          2. 基于@Configuration+@Bean的形式
 *                          3. 基于@Configuration+@Component/@Service/@Controller/@Repository注解方式
 *                          4. 基于@Configuration+@Import注解方式
 *                          5. 基于@Configuration+@Import注解和ImportSelector接口方式
 *                          6. 基于@Configuration+@Import注解和ImportBeanDefinitionRegistrar接口方式
 *                          7. 基于@Configuration+@Component注解方式和实现FactoryBean接口方式
 *                          8. 基于@Configuration+@Conditional注解(Spring4注解)+实现Condition接口方式
 * @Author moku
 * @Date 2022/12/10 11:05
 * @Version 1.0
 */
public class LoadBeanBy4ConfigurationImport {
    /**
     * 测试@Import注解引入外部资源交由Spring管理
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration4Import.class);
        Customer customer = context.getBean(Customer.class);
        System.out.println(customer);
        // 通过@Import注解引入的类不能根据名称进行注入，只能根据类型注入
        // 以下报容器内没有相应bean错误
        Customer customer1 = (Customer) context.getBean("customer");
        System.out.println(customer1);
    }
}
