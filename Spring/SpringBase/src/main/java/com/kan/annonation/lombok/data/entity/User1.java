package com.kan.annonation.lombok.data.entity;

import lombok.Data;

/**
 * @ClassName User1
 * @Description TODO
 * @Author moku
 * @Date 2022/12/10 0:53
 * @Version 1.0
 */
@Data
public class User1 extends User {
    private String userName;
    private Integer age;

    public User1(String userName, Integer age, Integer id, String name) {
        super(id, name);
        this.userName = userName;
        this.age = age;
    }
}
