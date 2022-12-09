package com.kan.beancreate.test;

import com.kan.beancreate.configuration.MyConfiguration;
import com.kan.beancreate.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName LoadBeanBy2ConfigurationBean
 * @Description 创建Bean方法：1. 基于XML配置
 *                          2. 基于Configuration和Bean的形式：当前测试类
 *                          3. 基于Configuration和@Component、@Service、@Controller、@Repository
 *                             注解方式
 * @Author moku
 * @Date 2022/12/10 2:08
 * @Version 1.0
 */
public class LoadBeanBy2ConfigurationBean {
    /**
     * 测试通过 @Configuration 和 @Bean的形式注入Bean
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Customer customer = (Customer) context.getBean("myCustomer");
        System.out.println(customer);
    }
}
