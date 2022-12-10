package com.kan.beancreate.test;

import com.kan.beancreate.configuration.MyConfiguration6ImportBeanDefinitionRegistrar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoadBeanBy6ConfigurationImportBeanDefinitionRegistrar
 * @Description 生成Bean方法：1. 基于XML配置
 *                          2. 基于@Configuration+@Bean的形式
 *                          3. 基于@Configuration+@Component/@Service/@Controller/@Repository注解方式
 *                          4. 基于@Configuration+@Import注解方式
 *                          5. 基于@Configuration+@Import注解和ImportSelector接口方式
 *                          6. 基于@Configuration+@Import注解和ImportBeanDefinitionRegistrar接口方式
 *                          7. 基于@Configuration+@Component注解方式和实现FactoryBean接口方式
 *                          8. 基于@Configuration+@Conditional注解(Spring4注解)+实现Condition接口方式
 * @Author moku
 * @Date 2022/12/10 14:20
 * @Version 1.0
 */
public class LoadBeanBy6ConfigurationImportBeanDefinitionRegistrar {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration6ImportBeanDefinitionRegistrar.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
            if (beanDefinitionNames[i].equals("myAddress")) {
                System.out.println("地址类：" + context.getBean("myAddress"));
            }
        }
    }
}
