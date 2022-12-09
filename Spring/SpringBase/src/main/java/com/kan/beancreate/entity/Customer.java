package com.kan.beancreate.entity;

import lombok.Data;

/**
 * @ClassName Customer
 * @Description
 * @Author moku
 * @Date 2022/12/10 0:06
 * @Version 1.0
 */
@Data
public class Customer {
    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private int age;

    public Customer() {
    }

    public Customer(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

