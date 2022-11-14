package com.kan.ioc.initial.entities;

/**
 * 测试对象，我们通过 IOC 来创建对象
 *
 * @author moku
 */
public class HelloIoc {
    // 无参构造
    public HelloIoc() {
        System.out.println("HelloIoc默认无参构造器");
    }

    public void sayHello() {
        System.out.println("Hello IOC");
    }
}
