package com.kan.beanscope.controller;

import com.kan.beanscope.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BeanScopesController
 * @Description TODO
 * @Author moku
 * @Date 2022/12/9 22:36
 * @Version 1.0
 */
@Controller
public class BeanScopesController2 {
    @Autowired
    private User userInComponent;
    public User getUser1() {
        User user = userInComponent;
        return user;
    }
}
