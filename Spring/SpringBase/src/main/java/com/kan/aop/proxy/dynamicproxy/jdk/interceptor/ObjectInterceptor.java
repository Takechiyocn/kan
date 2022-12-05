package com.kan.aop.proxy.dynamicproxy.jdk.interceptor;

import com.kan.aop.proxy.business.transactions.MyTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 自定义代理类(需实现代理类相关接口)
 * JDK动态代理：手动生成代理类(实现了接口InvocationHandler，为JDK动态代理)
 *   优点：1.后期在UserService中增加业务方法，无需增加代码，JDK动态代理可自动生成对象
 *        2.UserService可换成别的类，即可代理多个目标类，多个方法
 * 代理类：通知+切入点(此处{method.invoke(this.target, args);}调用的方法)
 * @author moku
 */
public class ObjectInterceptor implements InvocationHandler {
    // 目标类：需要被代理的类
    private Object target;
    // 切面类(此处指代事务)
    private MyTransaction transaction;

    // 构造器
    public ObjectInterceptor(Object target, MyTransaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 开启事务
        this.transaction.before();
        // 调用目标方法
        method.invoke(this.target, args);
        // 提交事务
        this.transaction.after();
        return null;
    }
}
