package logic.thread.juc.threadcooperation;

import logic.thread.juc.threadcooperation.semaphore.CustomizeBufferWithSemaphore;
import logic.thread.juc.threadcooperation.supplierconsumer.CustomizeBuffer;

/**
 * @ClassName Consumer
 * @Description
 * @Author moku
 * @Date 2022/12/23 3:16
 * @Version 1.0
 */
public class Consumer extends Thread {
    CustomizeBuffer buffer;
    CustomizeBufferWithSemaphore semaphoreBuffer;

    public Consumer(CustomizeBuffer buffer) {
        this.buffer = buffer;
    }

    public Consumer(CustomizeBufferWithSemaphore semaphoreBuffer) {
        this.semaphoreBuffer = semaphoreBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (null == buffer) {
                System.out.println("消费了第[" + semaphoreBuffer.remove().id + "个]产品");
            } else {
                System.out.println("消费了第[" + buffer.remove().id + "个]产品");
            }
        }
    }
}
