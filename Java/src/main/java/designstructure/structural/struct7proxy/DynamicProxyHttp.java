package designstructure.structural.struct7proxy;

import designstructure.structural.struct7proxy.dynamicproxy.HttpDynamicProxyInterceptor;
import designstructure.structural.struct7proxy.interfaces.HttpUtil;
import designstructure.structural.struct7proxy.interfaces.IHttp;

import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyHttp
 * @Description
 * @Author moku
 * @Date 2022/12/22 23:42
 * @Version 1.0
 */
public class DynamicProxyHttp {
    public static void main(String[] args) {

        Object target = new HttpUtil();
        HttpDynamicProxyInterceptor interceptor = new HttpDynamicProxyInterceptor(target);
        IHttp proxy = (IHttp) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                interceptor);
        proxy.request("request data");
        proxy.onSuccess("received data!");
    }
}
