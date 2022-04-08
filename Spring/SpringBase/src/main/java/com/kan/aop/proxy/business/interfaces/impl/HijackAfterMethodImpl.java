package com.kan.aop.proxy.business.interfaces.impl;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;


/**
 * JDK动态代理
 *
 * @author moku
 */
public class HijackAfterMethodImpl implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After method hijack");
    }
}
