package com.kan.beanscope.controller;

import com.kan.beanscope.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BeanScopesController
 * @Description
 * @Author moku
 * @Date 2022/12/9 22:36
 * @Version 1.0
 */
@Controller
public class BeanScopesController {
    // userInComponent代表User的的唯一bean，Autowired注解装配从Users类注入的userInComponent
    @Autowired
    private User userInComponent;
    public User getUser1() {
        User user = userInComponent;
        System.out.println("Bean原Name：" + user.getName());
        user.setName("Java-modify");
        return user;
    }
}
