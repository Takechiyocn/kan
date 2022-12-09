package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 原型模式：scope=“prototype”
 * 即Spring容器启动时不创建对象，在getBean时才创建对象，类似lazy-init
 * 
 * @author moku
 */
public class TestIOCMultiInstances {
    // 容器默认产生对象是单例的 scope="singleton"
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello1 = (HelloIoc) context.getBean("helloIoc");
        HelloIoc hello2 = (HelloIoc) context.getBean("helloIoc");
        // false
        System.out.println(hello1.equals(hello2));
    }
}
