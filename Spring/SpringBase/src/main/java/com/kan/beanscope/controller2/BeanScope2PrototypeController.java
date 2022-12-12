package com.kan.beanscope.controller2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanScope2PrototypeController
 * @Description
 * @Author moku
 * @Date 2022/12/12 20:32
 * @Version 1.0
 */
@Component
@Scope("prototype")
public class BeanScope2PrototypeController {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    public void getMessage() {
        System.out.println("Your message:" + message);
    }
}
