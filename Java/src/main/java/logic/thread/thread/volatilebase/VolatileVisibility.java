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
    private static boolean flag = true;

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("thread start");
            // 如果不加volatile线程对内存变化不知道
            // 线程使用时从类中复制拷贝一份到线程工作内存，如果修改线程内存中的值之后再写回到原先的位置，会有线程安全问题
            // 子线程处睡眠可能导致子线程获取到的flag已经被主线程修改
            while (flag) {
            }
            System.out.println("thread end");
        }).start();

        // 主线程睡眠和子线程睡眠
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("main end");
    }
}
