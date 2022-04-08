package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCreateObjectBySpring3InstanceFactory {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        HelloIoc hello = (HelloIoc) context.getBean("instance");
        hello.sayHello();
    }
}
