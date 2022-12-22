package com.kan.annonation.customize;

import java.lang.annotation.*;

/**
 * @ClassName FruitProvider
 * @Description 定义注解
 * @Author moku
 * @Date 2022/12/22 19:26
 * @Version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
