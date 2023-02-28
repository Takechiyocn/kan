package com.kan.threadpool.threadpoolTaskexecutor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async // 2.在需要异步执行的方法上加@Async
    public void helllo(int i) {
        log.info("异步线程启动：{}", i);
    }
}

