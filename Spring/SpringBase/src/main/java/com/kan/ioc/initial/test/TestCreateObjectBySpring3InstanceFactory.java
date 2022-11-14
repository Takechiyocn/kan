package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器创建对象：
 *   3. 利用实例工厂方法
 *
 * @author moku
 */
public class TestCreateObjectBySpring3InstanceFactory {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello = (HelloIoc) context.getBean("instance");
        hello.sayHello();
    }
}
