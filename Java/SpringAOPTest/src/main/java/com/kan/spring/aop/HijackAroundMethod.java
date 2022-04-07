package com.kan.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class HijackAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Method name : "
                + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : "
                + Arrays.toString(methodInvocation.getArguments()));
        // 等价于前置通知
        System.out.println("HijackAroundMethod : Before method hijacked!");

        try {
            // 环绕通知只能通过
            Object result = methodInvocation.proceed();
            // 等价于后置通知
            System.out.println("HijackAroundMethod : After method hijacked!");
            return result;
        } catch (IllegalArgumentException e) {
            // 等价于异常通知
            System.out.println("HijackAroundMethod : Throw exception hijacked!");
            throw e;
        }
    }
}
