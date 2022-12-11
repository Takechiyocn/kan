package com.kan.di.annotation.service3;

import com.kan.di.annotation.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UserService
 * @Description
 * @Author moku
 * @Date 2022/12/12 1:32
 * @Version 1.0
 */
@Service
public class UserService {
    // @Autowired装配多个实例
    // 此处注入由DiMultiBean2Impl1、DiMultiBean2Impl2类@Service注解注入的两个IUser的bean
    @Autowired
    private List<IUser> userList;

    @Autowired
    private Set<IUser> userSet;

    @Autowired
    private Map<String, IUser> userMap;

    public void test() {
        System.out.println("userList:" + userList);
        System.out.println("userSet:" + userSet);
        System.out.println("userMap:" + userMap);
    }
}
