package com.kan.threadpool.customizeThreadPool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 线程池配置
 * ThreadPoolTaskExecutor的使用
 * 自定义多个线程池 & 指定线程池使用
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
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        return executor;
    }

    // 自定义ThreadPoolTaskExecutor线程池
    @Bean(name = "customThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor customThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池参数
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix("myExecutor--");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        // 修改拒绝策略为使用当前线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程池
        executor.initialize();
        return executor;
    }

    // 自定义ThreadPoolTaskExecutor线程池
    @Bean(name = "customThreadPoolTaskExecutor11111")
    public ThreadPoolTaskExecutor customThreadPoolTaskExecutor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置线程池参数
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix("myExecutor11111--");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        // 修改拒绝策略为使用当前线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程池
        executor.initialize();
        return executor;
    }
}
