package com.kan.aop.proxy.business.interfaces.impl;

import org.springframework.aop.ThrowsAdvice;

public class HijackThrowExceptionImpl implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
