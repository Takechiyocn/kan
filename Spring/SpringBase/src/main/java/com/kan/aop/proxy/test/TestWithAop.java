package com.kan.aop.proxy.test;
import com.kan.aop.proxy.business.entities.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWithAop {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"SpringAOP.xml"});
        CustomerService cust = (CustomerService) appContext.getBean("customerServiceBeforeProxy");
        CustomerService cust2 = (CustomerService) appContext.getBean("customerServiceAfterProxy");
        CustomerService cust3 = (CustomerService) appContext.getBean("customerServiceThrowProxy");
        CustomerService cust4 = (CustomerService) appContext.getBean("customerServiceAroundProxy");

        System.out.println("*************************");
        cust4.printName();
        System.out.println("*************************");
        cust4.printUrl();
        System.out.println("*************************");
//        cust4.printThrowException();
//        System.out.println("*************************");
        try {
            cust4.printThrowException();
        } catch (Exception e) {
        }
    }
}
