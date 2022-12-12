package com.kan.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanScope1User
 * @Description
 * @Author moku
 * @Date 2022/12/9 22:34
 * @Version 1.0
 */
@Component
public class Users {
    @Bean
    public User user1() {
        User user = new User();
        user.setId(1L);
        user.setName("Java");
        return user;
    }
}
