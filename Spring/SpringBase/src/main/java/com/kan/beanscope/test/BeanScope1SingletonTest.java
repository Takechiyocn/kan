package com.kan.beanscope.test;

import com.kan.beanscope.configuration.BeanScope1SingletonConfiguration;
import com.kan.beanscope.controller.BeanScope1SingletonController;
import com.kan.beanscope.controller.BeanScope1SingletonController2;
import com.kan.beanscope.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanScope1SingletonTest
 * @Description
 * @Author moku
 * @Date 2022/12/9 22:40
 * @Version 1.0
 */
public class BeanScope1SingletonTest {
    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(BeanScope1SingletonConfiguration.class);
        BeanScope1SingletonController b = context.getBean(BeanScope1SingletonController.class);
        System.out.println("A对象修改之后Name：" + b.getUser1().toString());
        BeanScope1SingletonController2 b2 = context.getBean(BeanScope1SingletonController2.class);
        System.out.println("B对象读取到的Name：" + b2.getUser1().toString());
        User b3 = (User) context.getBean("userInComponent");
        System.out.println("最先注入的Bean获取Name："+ b3.toString());
    }
}
