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
    // @Autowired按type注解，此时注入User类型的Bean
    // 该Bean从Users类注入(Bean名称：userInComponent)，
    // 以下Autowired注解后，User的Bean名称：userInComponent3(通常使用相同名称userInComponent装配)
    @Autowired
    private User userInComponent3;
    public User getUser1() {
        User user = userInComponent3;
        return user;
    }
}
