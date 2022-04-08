package com.kan.aop.proxy.business.interfaces.impl;

import com.kan.aop.proxy.business.entities.User;
import com.kan.aop.proxy.business.interfaces.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("增加 User");
    }

    @Override
    public void deleteUser(int uid) {
        System.out.println("删除 User");
    }
}
