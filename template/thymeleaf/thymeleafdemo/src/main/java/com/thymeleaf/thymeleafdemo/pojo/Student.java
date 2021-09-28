package com.thymeleaf.thymeleafdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;

//    public Student(String name, Integer id) {
//        this.id = id;
//        this.name = name;
//    }

    // getter and setter
}
