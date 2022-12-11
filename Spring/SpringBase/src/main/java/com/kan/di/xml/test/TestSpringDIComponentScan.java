package com.kan.di.xml.test;

import com.kan.di.xml.entities.PersonComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDIComponentScan {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringAnnotationDI.xml");
        // 此处的person通过配置文件中设置的组件扫描，扫描到@Component注解的PersonComponent类获取
        PersonComponent personComponent = (PersonComponent) context.getBean("personComponent");
        System.out.println(personComponent.getPid());
    }
}
