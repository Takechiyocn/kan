package com.kan.aop.annotation.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 注解实现AOP
 *   Aspect:指定切面类
 *
 * @author moku
 */
@Aspect
public class LogAspects {

    // @Pointcut：公共切入点表达式
    @Pointcut("execution(int com.kan.aop.annotation.bean.MathCalculator.div(int, int))")
    public void pointCut() {}

    // @Before：前置通知
    // @JoinPoint：作为函数的参数传入切面方法，可以得到目标方法相关信息
    @Before("com.kan.aop.annotation.bean.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " 除法运行,参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    // @After：后置通知
    @After("com.kan.aop.annotation.bean.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }

    // @AfterReturning：返回通知
    @AfterReturning(value="com.kan.aop.annotation.bean.LogAspects.pointCut()", returning = "result")
    public void logReturn2(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法返回" + result);
    }

    // @AfterThrowing：异常通知
    @AfterThrowing(value = "com.kan.aop.annotation.bean.LogAspects.pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常");
    }
}
