package org.moku.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloService
 * @Description
 * @Author moku
 * @Date 2023/3/1 1:33
 * @Version 1.0
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    // 这里是提供者A的ip地址，但是如果使用了 Eureka 那么就应该是提供者A的名称
//    private static final String SERVICE_PROVIDER_1 = "http://localhost:8763";
    private static final String SERVICE_PROVIDER_1 = "http://service-provider1";

    public String helloService(String name) {
        String url = SERVICE_PROVIDER_1 + "/hello?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
