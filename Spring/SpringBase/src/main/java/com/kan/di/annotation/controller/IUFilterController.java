package com.kan.di.annotation.controller;

import com.kan.di.annotation.configuration.FilterConfig;
import com.kan.di.annotation.interfaces.IUser;
import com.kan.di.annotation.service3.UserService;
import com.kan.di.annotation.service4.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @ClassName IUFilterController
 * @Description
 * @Author moku
 * @Date 2022/12/12 1:36
 * @Version 1.0
 */
@RequestMapping("/f")
@RestController
public class IUFilterController {

//    @Autowired
//    @Autowired(required = false)
    private UserFilter userFilter;

    @Autowired
    @Qualifier("diMultiBean2Impl1")
    private IUser user;


    @RequestMapping("/test")
    public String test() throws ServletException {
        // 对于所有SpringBootWeb应用，均会按照：Listener->Filter->Servlet加载Bean
        userFilter.init(null);
        return "success";
    }
}
