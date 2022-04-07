package com.kan.proxy.business.interfaces.impl;

import com.kan.proxy.business.entities.User;
import com.kan.proxy.business.interfaces.UserService;

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
