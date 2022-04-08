package com.kan.aop.proxy.test;
import com.kan.aop.proxy.business.entities.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWithoutAop {
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
