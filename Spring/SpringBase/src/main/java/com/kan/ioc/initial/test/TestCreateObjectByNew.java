package com.kan.ioc.initial.test;

import com.kan.ioc.initial.entities.HelloIoc;

/**
 * 传统的创建对象的方法：new 关键字
 *
 * @author moku
 */
public class TestCreateObjectByNew {
    public static void main(String[] args) {
        HelloIoc hello = new HelloIoc();
        hello.sayHello();
    }
}
