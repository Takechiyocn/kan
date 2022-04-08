package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器创建对象：
 *   2. 利用静态工厂方法：静态工厂方法内部需自己实现
 *
 * @author moku
 */
public class TestCreateObjectBySpring2StaticFactory {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello = (HelloIoc) context.getBean("helloStaticFactory");
        hello.sayHello();
    }
}
