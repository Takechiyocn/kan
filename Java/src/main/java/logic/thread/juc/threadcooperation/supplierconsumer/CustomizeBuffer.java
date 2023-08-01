package logic.thread.juc.threadcooperation.supplierconsumer;

import logic.thread.juc.threadcooperation.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomizeBuffer
 * @Description
 * @Author moku
 * @Date 2022/12/23 3:03
 * @Version 1.0
 */
public class CustomizeBuffer {
    List<Product> l = new ArrayList<>();
    // 产品数量超过指定值后阻塞等待消费
    public static final int PRODUCT_LIMIT = 5;

    // 生产者
    public synchronized void add(Product p) {
        if (PRODUCT_LIMIT == l.size()) {
            try {
                System.out.println("货柜满，请稍等...");
                // 释放锁，等待消费者消费
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        l.add(p);
        this.notifyAll();
    }

    // 消费者
    public synchronized Product remove() {
        if (l.isEmpty()) {
            try {
                System.out.println("暂时没有产品，请稍等...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // TODO: 队列？先进先出
        Product p = l.remove(l.size() - 1);
        this.notifyAll();
        return p;
    }
}
