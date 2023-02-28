package org.moku.consumer.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplate
 * @Description
 * @Author moku
 * @Date 2023/3/1 1:32
 * @Version 1.0
 */
@Component
public class RestTemplateImpl {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
