package com.kan.di.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName SpringDiFilterApplication
 * @Description
 * @Author moku
 * @Date 2022/12/12 1:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableAsync
public class SpringDiFilterApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringDiFilterApplication.class, args);
    }
}
