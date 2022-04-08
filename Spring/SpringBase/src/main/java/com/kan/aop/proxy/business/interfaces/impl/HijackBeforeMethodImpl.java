package com.kan.aop.proxy.business.interfaces.impl;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class HijackBeforeMethodImpl implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("HijackBeforeMethodImpl : Before method hijacked!");
    }
}
