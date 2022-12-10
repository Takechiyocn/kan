package com.kan.beanlazyinit;

import com.kan.beanlazyinit.configuration.MyConfigurationLazyInit;
import com.kan.beanlazyinit.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanLazyInit
 * @Description
 * @Author moku
 * @Date 2022/12/10 22:39
 * @Version 1.0
 */
public class BeanLazyInit {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigurationLazyInit.class);
        // 懒加载：从容器中获取bean时才创建实例
        Customer customer = (Customer) context.getBean("customerLazyInit");
    }
}
