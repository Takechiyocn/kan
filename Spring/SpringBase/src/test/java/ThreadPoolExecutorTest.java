import com.kan.threadpool.threadpoolTaskexecutor.ToolsApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadPoolExecutor;
/**
 * @ClassName ThreadPoolExecutorTest
 * @Description
 * @Author moku
 * @Date 2023/2/28 12:03
 * @Version 1.0
 */
@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ToolsApplication.class)
public class ThreadPoolExecutorTest {

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;  //会去匹配 @Bean(name = "threadPoolExecutor") 这个线程池

    @Test
    public void testThreadPoolExecutor() {

        for (int i = 0; i < 10; i++) {
            final int index = i;
            // execute用来提交线程的执行
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("{}:{}", Thread.currentThread().getName(), index);
                }
            });
        }
    }
}

