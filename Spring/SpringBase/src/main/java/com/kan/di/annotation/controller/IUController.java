package com.kan.di.annotation.controller;

import com.kan.di.annotation.service3.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IUController
 * @Description
 * @Author moku
 * @Date 2022/12/12 1:36
 * @Version 1.0
 */
@RequestMapping("/u")
@RestController
public class IUController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        userService.test();
        return "success";
    }
}
