package logic.designstructure.structural.struct7proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName HttpDynamicProxyInterceptor
 * @Description
 * @Author moku
 * @Date 2022/12/22 23:26
 * @Version 1.0
 */
public class HttpDynamicProxyInterceptor implements InvocationHandler {
    private Object target;

    public HttpDynamicProxyInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        if ("request".equals(method.getName())) {
            System.out.println("发送数据:" + args[0]);
            method.invoke(this.target, args[0]);
        } else if ("onSuccess".equals(method.getName())) {
            System.out.println("收到数据:" + args[0]);
            method.invoke(this.target, args);
        }

        return result;
    }
}
