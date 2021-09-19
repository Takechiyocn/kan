package com.moku.userservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moku.bean.User;
import com.moku.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestUserService {

    // log4j
    Logger logger = LoggerFactory.getLogger(TestUserService.class);
    // jackson
    ObjectMapper mapper = new ObjectMapper();

    // 增
    @Test
    public void testAddUser() {

        User user = new User() {{
            this.setAge(20);
            this.setName("dynamic");
            this.setEmail("test");
            this.setPassword("pwd");
        }};
        UserService us = new UserService();
        us.addUser(user);
        logger.info("PK: {}", user.getId());
    }

    // 删
    @Test
    public void testDeleteUserById() {

        UserService us = new UserService();
        us.deleteUserById(101);
    }

    // 改
    @Test
    public void testUpdateUserById() {

        User userUpd = new User() {{
            this.setId(102L);
            this.setAge(22);
            this.setName("dynamic-1");
            this.setEmail("test-1");
            this.setPassword("pwd-1");
        }};
        UserService us = new UserService();
        us.updateUserById(userUpd);
    }

    // 查：按id查
    @Test
    public void testGetUserById() {

        UserService us = new UserService();
        User user = us.getUserById(102);
        try {
            String json = mapper.writeValueAsString(user);
            logger.info("User:{}", json);
        } catch (JsonProcessingException e) {
            logger.error("jackson error");
        }
    }

    // 查：查所有
    @Test
    public void testGetUser() {

        UserService us = new UserService();
        List<User> user = us.getUser();
        try {
            String json = mapper.writeValueAsString(user);
            logger.info("User:{}", json);
        } catch (JsonProcessingException e) {
            logger.error("jackson error");
        }
    }
}
