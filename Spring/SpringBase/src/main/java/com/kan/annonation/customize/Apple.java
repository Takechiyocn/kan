package com.kan.annonation.customize;

/**
 * @ClassName Apple
 * @Description 使用注解
 * @Author moku
 * @Date 2022/12/22 19:30
 * @Version 1.0
 */
public class Apple {
    @FruitProvider(id = 1, name = "User1", address = "sc")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
