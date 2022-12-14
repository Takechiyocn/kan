package thread.juc.async.runasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RunAsyncBase
 * @Description
 * @Author moku
 * @Date 2022/12/14 23:59
 * @Version 1.0
 */
public class RunAsyncBase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 发起一个请求
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "子线程阻塞后回调执行");
        });

        System.out.println("主线程未阻塞");
        // 回调：获取阻塞执行结果()
        // 若不回调，sleep后退出子线程
        future.get();
    }

}
