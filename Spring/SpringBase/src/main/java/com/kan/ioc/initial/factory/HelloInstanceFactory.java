package com.kan.ioc.initial.factory;

import com.kan.ioc.initial.entities.HelloIoc;

public class HelloInstanceFactory {

    public HelloInstanceFactory() {
        System.out.println("实例工厂方法构造函数");
    }

    // 利用实例工厂方法创建对象
    public HelloIoc getInstance() {
        HelloIoc instanceIoc = new HelloIoc();
        return instanceIoc;
    }
}
