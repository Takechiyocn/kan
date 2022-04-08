package com.kan.ioc.initial.factory;

import com.kan.ioc.initial.entities.HelloIoc;

public class HelloStaticFactory {

    public HelloStaticFactory() {
        System.out.println("静态工厂方法构造函数");
    }

    public static HelloIoc getInstances() {
        return new HelloIoc();
    }
}
