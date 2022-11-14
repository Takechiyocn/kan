package com.kan.ioc.initial.entities;

/**
 * Spring 容器的生命周期
 *
 * @author kan
 */
public class SpringLifeCycle {
    public SpringLifeCycle() {
        System.out.println("SpringLifeCycle constructor");
    }

    //定义初始化方法
    public void init() {
        System.out.println("Lifecycle:init...");
    }

    //定义销毁方法
    public void destroy() {
        System.out.println("Lifecycle:destroy...");
    }

    public void sayHello() {
        System.out.println("say Hello...");
    }
}
