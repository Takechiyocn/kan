package com.kan.beanlifecycle.service;

import com.kan.beanlifecycle.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description
 * @Author moku
 * @Date 2022/12/12 23:23
 * @Version 1.0
 */
@Service
public class UserLifeCycleAllService {
    @Bean
    public User userBean() {
        return new User();
    }
}
