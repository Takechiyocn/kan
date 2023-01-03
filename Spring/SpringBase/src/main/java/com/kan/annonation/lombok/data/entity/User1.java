package com.kan.annonation.lombok.data.entity;

import lombok.Data;

/**
 * @ClassName User1
 * @Description @Data注解只重写当前类的数据的比较方法，不重写父类数据(此处id, name)
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
