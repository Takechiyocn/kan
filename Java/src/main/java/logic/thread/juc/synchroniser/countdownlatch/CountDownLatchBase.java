package logic.thread.juc.synchroniser.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchBase
 * @Description
 * @Author moku
 * @Date 2022/12/13 1:32
 * @Version 1.0
 */
public class CountDownLatchBase {
    public static void main(String[] args) throws InterruptedException {

        // 相当于计数器
        CountDownLatch cd = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "==>start");
                // 当计数到达零，所有等待线程被释放，后续的await调用立即返回
                cd.countDown();
            }).start();
        }
        // 导致当前线程变为等待线程：等待计数到达零等待解除
        cd.await();
        System.out.println("main线程继续往下执行");
    }
}
