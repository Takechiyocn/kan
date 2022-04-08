package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器创建对象：
 *   1. 利用默认构造方法
 *
 * @author moku
 */
public class TestCreateObjectBySpring1DefaultConstructor {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello = (HelloIoc) context.getBean("helloIoc");
        hello.sayHello();

        // 利用配置文件 alias 别名属性创建对象
        HelloIoc hello2 = (HelloIoc) context.getBean("helloIoc2");
        hello2.sayHello();
    }
}
