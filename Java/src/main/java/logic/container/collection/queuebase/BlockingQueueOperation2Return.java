package logic.container.collection.queuebase;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName BlockingQueueOperation1Exception
 * @Description
 * @Author moku
 * @Date 2022/12/13 13:20
 * @Version 1.0
 */
public class BlockingQueueOperation2Return {
    /**
     * 有返回值没有异常
     */
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
//        System.out.println(queue.offer("d"));       //offer 不抛出异常
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.poll());   //null 不抛出异常
    }
}
