package com.kan.aop.annotation.test;

import com.kan.aop.annotation.bean.MathCalculator;
import com.kan.aop.annotation.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        // 1：通过类名获取bean
//        context.getBean(MathCalculator.class).div(4, 2);
        // 2：获取注解后别名bean
        MathCalculator mathCalculator = (MathCalculator)context.getBean("mathCalculator");
        mathCalculator.div(4, 2);
    }
}
