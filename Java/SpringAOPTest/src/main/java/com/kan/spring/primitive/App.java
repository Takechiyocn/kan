package com.kan.spring.primitive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"SpringAOP.xml"});
        CustomerService cust = (CustomerService) appContext.getBean("customerService");
        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printUrl();
        System.out.println("*************************");
        try {
            cust.printThrowException();
        } catch (Exception e) {
        }
    }
}
