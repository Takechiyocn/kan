package com.kan.beanscope.test;

import com.kan.beanscope.configuration.BaseScopeConfiguration;
import com.kan.beanscope.controller.BeanScopesController;
import com.kan.beanscope.controller.BeanScopesController2;
import com.kan.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanScopeTest
 * @Description TODO
 * @Author moku
 * @Date 2022/12/9 22:40
 * @Version 1.0
 */
public class BeanScopeTest {
    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(BaseScopeConfiguration.class);
        BeanScopesController b = context.getBean(BeanScopesController.class);
        System.out.println("A对象修改之后Name：" + b.getUser1().toString());
        BeanScopesController2 b2 = context.getBean(BeanScopesController2.class);
        System.out.println("B对象读取到的Name：" + b2.getUser1().toString());
    }
}
