import com.kan.threadpool.threadpoolTaskexecutor.ToolsApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot中自定义多个线程池 & 指定线程池使用
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ToolsApplication.class)
@Slf4j
public class SpringBootCustomThreadPoolTest {

    // SpringBoot中使用个性化配置后的ThreadPoolTaskExecutor线程池 自定义线程池 customThreadPoolTaskExecutor
    @Autowired
    private ThreadPoolTaskExecutor customThreadPoolTaskExecutor; // 会去匹配 @Bean("customThreadPoolTaskExecutor") 这个线程池

    // SpringBoot中使用个性化配置后的ThreadPoolTaskExecutor线程池 自定义线程池 customThreadPoolTaskExecutor1
    @Autowired
    private ThreadPoolTaskExecutor customThreadPoolTaskExecutor11111; // 会去匹配 @Bean("customThreadPoolTaskExecutor11111") 这个线程池


    @Test
    public void testCustomThreadPoolTaskExecutor() {
        // SpringBoot中使用自定义线程池 customThreadPoolTaskExecutor
        for (int j = 0; j < 10; j++) {
            final int index = j;
            customThreadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("###SpringBoot中使用自定义线程池 customThreadPoolTaskExecutor 创建线程 异步执行：{}", index);
                }
            });
        }

        // SpringBoot中使用自定义线程池 customThreadPoolTaskExecutor1
        for (int j = 0; j < 10; j++) {
            final int index = j;
            customThreadPoolTaskExecutor11111.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("###SpringBoot中使用自定义线程池 customThreadPoolTaskExecutor11111 创建线程 异步执行：{}", index);
                }
            });
        }
    }
}

