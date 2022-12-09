package com.kan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 不添加request作用域，默认单例的Controller输出：1、1
 * 添加request作用后，变为多例Bean的输出：1、2
 */
@Controller
@RequestMapping("/demo/lsh/ch5")
@Scope("request")
public class MultiViewController {
    //非静态
    private int index = 0;

    @RequestMapping("/show")
    public String toShow(ModelMap model) {
        System.out.println(++index);
        return "/lsh/ch5/show";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println(++index);
        return "/lsh/ch5/test";
    }
}
