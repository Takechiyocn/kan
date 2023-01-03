package com.kan.annonation.lombok.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName User1
 * @Description 显示使用@EqualsAndHashCode(callSuper=true)注解
 * @Author moku
 * @Date 2022/12/10 0:53
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User2 extends User {
    private String userName;
    private Integer age;

    public User2(String userName, Integer age, Integer id, String name) {
        super(id, name);
        this.userName = userName;
        this.age = age;
    }
}
