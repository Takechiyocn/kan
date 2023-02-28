package com.kan.threadpool.threadpoolTaskexecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动程序
 */
@SpringBootApplication
@EnableAsync // 开启异步   1.在Application启动类上面加上@EnableAsync ！！！！！！！！！！
public class ToolsApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ToolsApplication.class, args);
    }

}
