package com.kan.aop.proxy.business.interfaces;

import com.kan.aop.proxy.business.entities.User;

public interface UserService {
    //添加 user
    public void addUser(User user);

    //删除 user
    public void deleteUser(int uid);
}