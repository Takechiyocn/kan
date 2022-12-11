package com.kan.di.annotation.test;

import com.kan.di.annotation.configuration.DiMultiBean1Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName DiMultiBean1MultiAnnoTest
 * @Description
 * @Author moku
 * @Date 2022/12/11 22:06
 * @Version 1.0
 */
public class DiMultiBean1MultiAnnoTest {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DiMultiBean1Configuration.class);
    }
}
