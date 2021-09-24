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
        students.add(new Student("张三", 1));
        students.add(new Student("李四", 2));
        students.add(new Student("王五", 3));
        students.add(new Student("二麻子", 4));
        students.add(new Student("三棒子", 5));
        model.addAttribute("students", students);
        model.addAttribute("student", new Student("console student", 10));

        List<Teacher> teachers = new ArrayList<>();
        model.addAttribute("teachers", teachers);

        return "hello";
    }
}