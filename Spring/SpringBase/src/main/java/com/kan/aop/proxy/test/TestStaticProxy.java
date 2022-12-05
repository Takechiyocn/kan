package com.kan.aop.proxy.test;

import com.kan.aop.proxy.business.interfaces.UserService;
import com.kan.aop.proxy.business.interfaces.impl.UserServiceImpl;
import com.kan.aop.proxy.staticproxy.proxy.ProxyUser;
import com.kan.aop.proxy.business.transactions.MyTransaction;

public class TestStaticProxy {

    public static void main(String[] args) {
        MyTransaction transaction = new MyTransaction();
        UserService userService = new UserServiceImpl();

        // 静态代理对象
        ProxyUser proxy = new ProxyUser(userService, transaction);
        proxy.addUser(null);
        proxy.deleteUser(0);
    }
}
