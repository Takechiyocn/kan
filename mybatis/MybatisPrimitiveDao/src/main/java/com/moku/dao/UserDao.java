package com.moku.dao;

import com.moku.bean.User;

import java.util.List;

/**
 * 接口（原始dao开发中的UserDao）
 *
 * @author moku
 */
public interface UserDao {

    // 增
    boolean addUser(User user);

    // 删
    boolean deleteUserById(int id);

    // 改
    boolean updateUserById(User user);

    // 查：按id查一个
    User getUserById(int id);

    // 查：查所有
    List<User> getUser();

}
