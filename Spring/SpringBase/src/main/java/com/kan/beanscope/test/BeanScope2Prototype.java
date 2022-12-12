package com.kan.beanscope.test;

import com.kan.beanscope.controller2.BeanScope2PrototypeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName BeanScope2Prototype
 * @Description
 * @Author moku
 * @Date 2022/12/12 20:35
 * @Version 1.0
 */
public class BeanScope2Prototype {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeanScopePrototype.xml");

        BeanScope2PrototypeController prototypeBean = context.getBean(BeanScope2PrototypeController.class);
        prototypeBean.setMessage("This is A!");
        prototypeBean.getMessage();

        BeanScope2PrototypeController prototypeBean2 = (BeanScope2PrototypeController) context.getBean("beanScope2PrototypeController");
        prototypeBean2.getMessage();
    }
}
