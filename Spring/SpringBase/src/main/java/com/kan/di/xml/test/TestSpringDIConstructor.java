package com.kan.di.xml.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kan.di.xml.entities.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDIConstructor {
    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringDI.xml");
        Person person = (Person) context.getBean("person-con");
        System.out.println(person.getPid());
    }
}
