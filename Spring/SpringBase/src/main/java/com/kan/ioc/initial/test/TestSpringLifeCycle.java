package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.SpringLifeCycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 * @author moku
 */
public class TestSpringLifeCycle {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringLifeCycle.xml");
        SpringLifeCycle lifeCycle = (SpringLifeCycle) context.getBean("springLifeCycle");
        lifeCycle.sayHello();

        // 销毁Spring容器，原型模式(scope="prototype")不会销毁Spring容器
        // 原型模式下，spring的ioc不再管理我们自定义的销毁方法
        ClassPathXmlApplicationContext classContext = (ClassPathXmlApplicationContext) context;
        classContext.close();
    }
}
