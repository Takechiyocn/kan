package logic.container.collection.queuebase;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName BlockingQueueOperation1Exception
 * @Description
 * @Author moku
 * @Date 2022/12/13 13:20
 * @Version 1.0
 */
public class BlockingQueueOperation3Blocking {
    /**
     *  等待阻塞
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
//        queue.put("c");  队列没有位置就会阻塞
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
