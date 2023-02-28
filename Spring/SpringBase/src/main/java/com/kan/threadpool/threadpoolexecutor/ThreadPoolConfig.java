package com.kan.threadpool.threadpoolexecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolConfig
 * @Description 线程池配置
 * @Author moku
 * @Date 2023/2/28 11:59
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    @Value("${threadPool.spring.corePoolSize}")
    private Integer corePoolSize;

    @Value("${threadPool.spring.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${threadPool.spring.queueCapacity}")
    private Integer queueCapacity;

    @Value("${threadPool.spring.keepAliveSeconds}")
    private Integer keepAliveSeconds;

    // SpringBoot中使用ThreadPoolExecutor
    @Bean(name = "threadPoolExecutor")
    public ExecutorService threadPoolExecutor() {
        ExecutorService executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        return executor;
    }
}
