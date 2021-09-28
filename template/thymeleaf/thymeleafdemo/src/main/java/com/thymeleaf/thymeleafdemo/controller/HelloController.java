package com.thymeleaf.thymeleafdemo.controller;

import com.thymeleaf.thymeleafdemo.pojo.Student;
import com.thymeleaf.thymeleafdemo.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "thymeleaf");
        model.addAttribute("name2", "thymeleaf2");
        model.addAttribute("name3", "thymeleaf3");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "张三"));
        students.add(new Student(2, "李四"));
        students.add(new Student(3, "王五"));
        students.add(new Student(4, "二麻子"));
        students.add(new Student(5, "三棒子"));
        model.addAttribute("students", students);
        model.addAttribute("student", new Student(10, "console student"));

        List<Teacher> teachers = new ArrayList<>();
        model.addAttribute("teachers", teachers);

        return "hello";
    }
}