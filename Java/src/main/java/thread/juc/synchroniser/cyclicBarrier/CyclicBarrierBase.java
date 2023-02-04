package thread.juc.synchroniser.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierBase
 * @Description
 * @Author moku
 * @Date 2022/12/13 1:46
 * @Version 1.0
 */
public class CyclicBarrierBase {
    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(7, () ->
                System.out.println("所有线程到达屏障点后打开屏障：召唤神龙成功！"));

        for (int i = 1; i < 8; i++) {
            int n = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集" + n + "个龙珠");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("main线程！");
    }
}
