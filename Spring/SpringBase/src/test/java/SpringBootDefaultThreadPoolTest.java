import com.kan.threadpool.threadpoolTaskexecutor.AsyncService;
import com.kan.threadpool.threadpoolTaskexecutor.ToolsApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * 在springboot当中，根据 官方文档的说明，如果没有配置线程池的话，
 * springboot会自动配置一个ThreadPoolTaskExecutor 线程池到bean当中，我们只需要按照他的方式调用就可以了！！！
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ToolsApplication.class)
@Slf4j
public class SpringBootDefaultThreadPoolTest {

    // 方式一：@Enable+@Async
    @Autowired
    AsyncService asyncService;

    // 方式二：直接注入ThreadPoolTaskExecutor
    @Autowired
    Executor threadPoolTaskExecutor;

    @Autowired
    private ExecutorService executorService;

    @Test
    public void testDefaultPool() {
        // 方式一
        for (int i = 0; i < 10; i++) {
            asyncService.helllo(i);
        }

        // 方式二
        for (int j = 0; j < 10; j++) {
            final int index = j;
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("threadPoolTaskExecutor 创建线程 异步执行：{}", index);
                }
            });
        }

        // 方式三
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

    }
}

