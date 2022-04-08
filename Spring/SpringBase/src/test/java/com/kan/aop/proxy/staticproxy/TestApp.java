package com.kan.aop.proxy.staticproxy;

import com.kan.aop.proxy.business.interfaces.UserService;
import com.kan.aop.proxy.business.interfaces.impl.UserServiceImpl;
import com.kan.aop.proxy.staticproxy.proxy.ProxyUser;
import com.kan.aop.proxy.business.transactions.MyTransaction;
import org.junit.jupiter.api.Test;

public class TestApp {

    @Test
    public void testOne() {
        MyTransaction transaction = new MyTransaction();
        UserService userService = new UserServiceImpl();

        // 静态代理对象
        ProxyUser proxy = new ProxyUser(userService, transaction);
        proxy.addUser(null);
        proxy.deleteUser(0);
    }
}
