package com.kan.controller.test;

import com.kan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BeanScopeTest
 * @Description TODO
 * @Author moku
 * @Date 2022/12/9 22:40
 * @Version 1.0
 */
public class BeanScopeTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml");

        User user = context.getBean(User.class);

        System.out.println(user.getName());
//        System.out.println("A对象修改之后Name：" + beanScopesController.getUser1().toString());
    }
}
