package thread.juc.async.supplyasync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName SupplyAsyncBase
 * @Description
 * @Author moku
 * @Date 2022/12/15 0:07
 * @Version 1.0
 */
public class SupplyAsyncBase {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "子线程执行");
            return 1024;
        });

        // whenComplete
        //  t:正常返回结构
        //  u:抛出异常的错误信息
        // 异常发生时，get()方法会得到exceptionally里的信息
        System.out.println(future.whenComplete((t, u) -> {
            System.out.println("t:" + t + ",u=" + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 512;
        }).get());
    }
}
