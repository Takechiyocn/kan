package com.kan.beanlifecycle.test;

import com.kan.beanlifecycle.controller.UserLifeCycleAllController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UserLifeCycleAllTest
 * @Description
 * @Author moku
 * @Date 2022/12/12 23:34
 * @Version 1.0
 */
public class UserLifeCycleAllTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringLifeCycleAll.xml");
        UserLifeCycleAllController controller = context.getBean("userLifeCycleAllController", UserLifeCycleAllController.class);
//        controller.destroy();
        // 销毁上下文环境时执行PreDestroy方法
        context.close();
    }
}
