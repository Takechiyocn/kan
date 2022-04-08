package com.kan.aop.proxy.business.transactions;

public class MyTransaction {
    // 开启事务
    public void before() {
        System.out.println("开启事务");
    }

    // 提交事务
    public void after() {
        System.out.println("提交事务");
    }
}
