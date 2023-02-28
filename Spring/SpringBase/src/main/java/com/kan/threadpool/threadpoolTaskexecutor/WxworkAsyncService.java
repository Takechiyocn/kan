package com.kan.threadpool.threadpoolTaskexecutor;

/**
 * @ClassName WxworkAsyncService
 * @Description
 * @Author moku
 * @Date 2023/2/28 13:23
 * @Version 1.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 使用@Enable + @Async快速实现异步
 */
@Service
public class WxworkAsyncService {

    private static final Logger log = LoggerFactory.getLogger(WxworkAsyncService.class);

    @Async
    public void async() {
        try {
            // 模拟业务执行操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("### WxworkAsyncService InterruptedException ", e);
        }
        log.info("{} -- {}", System.currentTimeMillis(), Thread.currentThread().getName());
    }
}
