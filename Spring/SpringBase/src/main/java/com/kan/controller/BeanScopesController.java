package com.kan.controller;

import com.kan.entity.User;
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
    @Autowired
    private User user1;
    @Bean
    public User getUser1() {
        User user = user1;
        System.out.println("Bean原Name：" + user.getName());
        return user;
    }
}
