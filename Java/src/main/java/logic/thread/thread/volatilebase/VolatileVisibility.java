package logic.thread.thread.volatilebase;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VolatileVisibility
 * @Description
 * @Author moku
 * @Date 2022/12/15 0:42
 * @Version 1.0
 */

public class VolatileVisibility {
    // 不加volatile程序死循环，volatile可保证可见性
    private boolean flag = false;
    public static void main(String[] args) {

        VolatileVisibility v = new VolatileVisibility();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 如果不加volatile线程对内存变化不知道
            while (v.flag) {
            }
        }).start();
        v.flag = true;
        System.out.println(v.flag);
    }
}
