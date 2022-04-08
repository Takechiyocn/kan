package com.kan.aop.annotation.bean;

public class MathCalculator {
    public int div(int x, int y) {
        System.out.println(x / y);
        return x / y;
    }
}
