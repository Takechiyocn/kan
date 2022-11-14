package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 默认作用域scope是单例(singleton)，即产生的对象是单例
 *
 * @author moku
 */
public class TestIOCSingleton {
    // spring 容器默认产生对象是单例的 scope="singleton"
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello1 = (HelloIoc) context.getBean("helloStaticFactory");
        HelloIoc hello2 = (HelloIoc) context.getBean("helloStaticFactory");
        // true
        System.out.println(hello1.equals(hello2));
    }
}
