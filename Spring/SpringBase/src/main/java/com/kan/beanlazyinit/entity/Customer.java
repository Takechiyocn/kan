package com.kan.beanlazyinit.entity;

import lombok.Data;

/**
 * @ClassName Customer
 * @Description
 * @Author moku
 * @Date 2022/12/10 22:34
 * @Version 1.0
 */
@Data
public class Customer {
    private String userName;
    private int age;

    public Customer() {
        System.out.println("Customer无参构造被触发了。。。。");
    }

    public Customer(String userName, int age) {
        System.out.println("Customer有参构造被触发了。。。。");
        this.userName = userName;
        this.age = age;
    }
}
