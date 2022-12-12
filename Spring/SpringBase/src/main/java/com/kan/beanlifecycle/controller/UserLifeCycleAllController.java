package com.kan.beanlifecycle.controller;

import com.kan.beanlifecycle.service.UserLifeCycleAllService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName UserLifeCycleAllController
 * @Description
 * @Author moku
 * @Date 2022/12/12 23:26
 * @Version 1.0
 */
public class UserLifeCycleAllController implements BeanNameAware {

    @Autowired
    private UserLifeCycleAllService userLifeCycleAllService;

    // 1. 各种通知
    @Override
    public void setBeanName(String s) {
        System.out.println("执行通知：" + s);
    }

    // 2. 初始化方法
    @PostConstruct
    public void postConstruct() {
        System.out.println("执行@PostConstruct方法");
    }

    // 3. 自定义初始化方法
    public void init() {
        System.out.println("执行init方法");
    }

    // 4. 销毁前方法
    @PreDestroy
    public void preDestroy() {
        System.out.println("执行@PreDestroy方法");
    }

    // 5. 自定义销毁方法
    public void destroy() {
        System.out.println("执行destroy方法");
    }
}
