package com.kan.threadpool.AsyncConfigurer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 实现AsyncConfigurer接口，自定义线程池，并通过@Async注解使用 (该注解使用在需要在新线程中执行的方法上)
 *
 * @Async 注解在service内的方法上(@EnableAsync开启异步)，可以实现在controller的异步调用，
 * 调用的被@Async注解的方法会在一个单独线程内运行，适合即使返回，异步解耦，service慢慢去处理
 *
 * @Async 注解的方法只能 返回void或者future类型的返回值，其他值会使 注解无效，因为不能异步执行
 *
 * 当implements AsyncConfigurer接口实现了自定义的异步线程池后，会默认覆盖spring自带的异步线程池
 */
@Configuration
@EnableAsync
@Slf4j
public class SpringThreadPoolConfig implements AsyncConfigurer {

    @Value("${threadPool.spring.corePoolSize}")
    private Integer corePoolSize;

    @Value("${threadPool.spring.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${threadPool.spring.queueCapacity}")
    private Integer queueCapacity;

    @Value("${threadPool.spring.keepAliveSeconds}")
    private Integer keepAliveSeconds;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setThreadNamePrefix("MyAsync-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }
}

/**
 * 自定义异常处理类
 * 被 @Async 修饰的方法在独立线程调用，不能被@ControllerAdvice全局异常处理器捕获，所以需要自己设置异常处理
 */
@Slf4j
class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (Object param: objects) {
            log.info("Parameter value - " + param);
        }
        log.error("handleUncaughtException method:" + method.getName(), throwable);
    }
}
