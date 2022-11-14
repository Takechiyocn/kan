package com.kan.di.xml.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kan.di.xml.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDI {
    static Logger logger = LoggerFactory.getLogger(TestSpringDI.class);
    // jackson
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringDI.xml");
        Person person = (Person) context.getBean("person");
        String json = mapper.writeValueAsString(person);
        logger.info("Person{}", json);
    }
}
