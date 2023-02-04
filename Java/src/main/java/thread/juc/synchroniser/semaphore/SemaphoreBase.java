package thread.juc.synchroniser.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreBase
 * @Description
 * @Author moku
 * @Date 2022/12/13 2:02
 * @Version 1.0
 */
public class SemaphoreBase {
    public static void main(String[] args) {

        // 允许同时存在最大3个信号量
        Semaphore sh = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            int n = i;
            new Thread(() -> {
                try {
                    // 获取信号量，如果已经满了,等待信号量可用时被唤醒
                    sh.acquire();
                    System.out.println(n + "号车抢到车位");
                    // 让其他线程获取信号量
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放信号量
                    sh.release();
                    System.out.println(n + "号车离开车位");
                }
            }).start();
        }
    }
}
