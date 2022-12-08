package com.kan.controller;

import com.kan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author moku
 * @Date 2022/12/8 15:46
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Autowired根据type进行注解，不匹配name
    // 接口实现类有多个时，需要配合修饰注解Qualifier或Primary使用
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService2;

    // 编译不报错，运行时报错
    @Resource
    private UserService userService3;

    // 默认byName注入策略
    // 1. 如果设置type值，则使用byType注入策略
    // 2. name、type均不指定，利用反射机制使用byName注入
    @Resource(name = "userServiceImpl")
    private UserService userService4;
}
