package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 容器创建对象的时机
 *   1. lazy-init延迟到getBean时才创建对象
 *      -> 可减少内存消耗，不容易发现错误
 *
 * @author moku
 */
public class TestCreateObjectTimingLazyInit {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
        // 执行下列getBean方法时，才创建对象
        HelloIoc hello = (HelloIoc) context.getBean("instance");
        hello.sayHello();
    }
}
