package logic.thread.thread;

import java.util.Random;

/**
 * @ClassName ThreadPriority
 * @Description 线程优先级(1~10)：默认为5
 *                              线程优先级和执行顺序无关
 * @Author moku
 * @Date 2022/12/23 2:18
 * @Version 1.0
 */
public class ThreadPriority {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                System.out.println(Thread.currentThread().getThreadGroup()+", ThreadName[" +Thread.currentThread().getName()+"]," + " priority:"
                        + Thread.currentThread().getPriority());
            });
            t.setPriority(i + new Random(6).nextInt(6));
            t.start();
        }
    }
}
