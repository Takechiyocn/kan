package logic.thread.juc.threadcooperation.semaphore;

import logic.thread.juc.threadcooperation.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomizeBufferWithSemaphore
 * @Description
 * @Author moku
 * @Date 2022/12/23 3:03
 * @Version 1.0
 */
public class CustomizeBufferWithSemaphore {
    // 标志位：
    //  true：当前商品不足，可以生产
    //  false：当前商品充足，暂停生产
    boolean flag = true;
    List<Product> l = new ArrayList<>();
    // 产品数量超过指定值后阻塞等待消费
    public static final int PRODUCT_LIMIT = 5;

    // 生产者
    public synchronized void add(Product p) {
        while (!flag) {
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

        // 当商品柜满时，暂停生产
//        if (PRODUCT_LIMIT == l.size()) {
            flag = !flag;
//        }
    }

    // 消费者
    public synchronized Product remove() {
        while (flag) {
            try {
                System.out.println("暂时没有产品，请稍等...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product p = l.remove(l.size() - 1);
        this.notifyAll();

        // 当商品柜没货时，继续生产
//        if (l.isEmpty()) {
            flag = !flag;
//        }

        return p;
    }
}
