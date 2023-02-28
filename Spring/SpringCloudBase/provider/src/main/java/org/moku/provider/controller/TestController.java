package org.moku.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author moku
 * @Date 2023/3/1 1:00
 * @Version 1.0
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String provider;

    @RequestMapping(value = "hi")
    public void hi() {
        System.out.println("hello, this is provider 1");
    }

    @RequestMapping(value = "hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + ", i am from port:" + port + ", provider:" + provider;
    }
}
