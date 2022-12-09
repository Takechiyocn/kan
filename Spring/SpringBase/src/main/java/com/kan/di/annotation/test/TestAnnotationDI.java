package com.kan.di.annotation.test;

import com.kan.di.annotation.entities.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationDI {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringAnnotationDI.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.getPid());
    }
}
