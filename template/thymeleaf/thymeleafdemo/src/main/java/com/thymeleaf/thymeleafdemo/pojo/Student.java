package com.thymeleaf.thymeleafdemo.pojo;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer id;

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    // getter and setter
}
