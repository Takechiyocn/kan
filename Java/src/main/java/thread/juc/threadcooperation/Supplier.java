package thread.juc.threadcooperation;

import thread.juc.threadcooperation.semaphore.CustomizeBufferWithSemaphore;
import thread.juc.threadcooperation.supplierconsumer.CustomizeBuffer;

/**
 * @ClassName Supplier
 * @Description
 * @Author moku
 * @Date 2022/12/23 3:00
 * @Version 1.0
 */
public class Supplier extends Thread {
    CustomizeBuffer buffer;
    CustomizeBufferWithSemaphore semaphoreBuffer;

    public Supplier(CustomizeBuffer buffer) {
        this.buffer = buffer;
    }

    public Supplier(CustomizeBufferWithSemaphore semaphoreBuffer) {
        this.semaphoreBuffer = semaphoreBuffer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 21; i++) {
            if (null == buffer) {
                semaphoreBuffer.add(new Product(i));
            } else {
                buffer.add(new Product(i));
            }
            System.out.println("生产了第[" + i + "]个产品");
        }
    }
}
