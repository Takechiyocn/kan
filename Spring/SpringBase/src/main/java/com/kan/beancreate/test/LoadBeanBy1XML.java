package com.kan.beancreate.test;

import com.kan.beancreate.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName LoadBeanBy1XML
 * @Description 创建Bean方法：1. 基于XML配置：当前测试类
 *                          2. 基于Configuration和Bean的形式
 * @Author moku
 * @Date 2022/12/10 1:57
 * @Version 1.0
 */
public class LoadBeanBy1XML {
    /**
     * 测试xml的方式进行Bean的创建
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeanCreate.xml");
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);
    }
}
