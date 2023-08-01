package logic.container.collection.queuebase;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName BlockingQueueOperation1Exception
 * @Description
 * @Author moku
 * @Date 2022/12/13 13:20
 * @Version 1.0
 */
public class BlockingQueueOperation1Exception {
    /**
     * 抛出异常
     */
    public static void main(String[] args) {
        //队列的大小
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        //java.lang.IllegalStateException: Queue full
        //System.out.println(queue.add("d"));
        System.out.println("----------------------");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //java.util.NoSuchElementException
        System.out.println(queue.remove());
        //抛出异常
    }
}
