package designstructure.structural.struct7proxy;

import designstructure.structural.struct7proxy.staticproxy.HttpProxy;
import designstructure.structural.struct7proxy.interfaces.HttpUtil;

/**
 * @ClassName StaticProxyHttp
 * @Description
 * @Author moku
 * @Date 2022/12/22 23:18
 * @Version 1.0
 */
public class StaticProxyHttp {
    public static void main(String[] args) {

        HttpUtil util = new HttpUtil();
        HttpProxy proxy = new HttpProxy(util);
        proxy.request("request data");
        proxy.onSuccess("received result");
    }
}
