package org.moku.consumer.controller;

import org.moku.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author moku
 * @Date 2023/3/1 1:42
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
