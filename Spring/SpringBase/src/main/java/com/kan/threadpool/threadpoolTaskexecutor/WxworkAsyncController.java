package com.kan.threadpool.threadpoolTaskexecutor;

/**
 * @ClassName WxworkAsyncController
 * @Description
 * @Author moku
 * @Date 2023/2/28 13:22
 * @Version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用@Enable + @Async快速实现异步
 */
@RestController
@RequestMapping("/WxworkAsyncController")
public class WxworkAsyncController {

    @Autowired
    private WxworkAsyncService wxworkAsyncService;

    @GetMapping("async")
    public String async() {
        // 模拟异步处理任务
        wxworkAsyncService.async();
        return "success123213213fffff";
    }
}
