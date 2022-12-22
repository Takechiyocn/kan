package thread.juc.threadcooperation.supplierconsumer;

import thread.juc.threadcooperation.Consumer;
import thread.juc.threadcooperation.Supplier;

/**
 * @ClassName SupplierAndConsumerTest
 * @Description 线程协作：生产者消费者方法/管程法
 * @Author moku
 * @Date 2022/12/23 2:59
 * @Version 1.0
 */
public class SupplierAndConsumerTest {
    public static void main(String[] args) {

        CustomizeBuffer buffer = new CustomizeBuffer();

        new Supplier(buffer).start();
        new Consumer(buffer).start();
    }
}

