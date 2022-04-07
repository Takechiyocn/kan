package com.kan.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;


/**
 * CGLib动态代理
 *
 * @author moku
 */
public class HijackAfterMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After method hijack");
    }
}
