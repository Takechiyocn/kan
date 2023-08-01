package logic.thread.juc.threadcooperation.semaphore;

import logic.thread.juc.threadcooperation.Consumer;
import logic.thread.juc.threadcooperation.Supplier;

/**
 * @ClassName SemaphoreTest
 * @Description 线程协作：信号灯法
 * @Author moku
 * @Date 2022/12/23 2:59
 * @Version 1.0
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        CustomizeBufferWithSemaphore buffer = new CustomizeBufferWithSemaphore();

        new Supplier(buffer).start();
        new Consumer(buffer).start();
    }
}

