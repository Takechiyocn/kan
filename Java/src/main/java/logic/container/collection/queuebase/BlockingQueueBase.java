package logic.container.collection.queuebase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockingQueueBase
 * @Description
 * @Author moku
 * @Date 2022/12/14 19:34
 * @Version 1.0
 */
public class BlockingQueueBase {

    public static void main(String[] args) throws InterruptedException {

        // 抛出异常：add、remove、element
//        throwExceptionOperation();

        // 返回特殊值：offer、poll、peek
//        returnOperation();

        // 阻塞等待：put、take
//        blockingThread();

        // 阻塞超时等待：offer(,)、pull(,)
        blockingTimedThread();
    }

    // 抛出异常：java.lang.IllegalStateException: Queue full
    private static void throwExceptionOperation() {
        // 队列的大小为3
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // add()方法返回boolean值
        boolean flag1 = blockingQueue.add("a");
        boolean flag2 = blockingQueue.add("b");
        boolean flag3 = blockingQueue.add("c");
        // add添加元素超过队列的长度会抛出异常java.lang.IllegalStateException: Queue full
        boolean flag4 = blockingQueue.add("d");
        // 获得队首元素
        System.out.println(blockingQueue.element());
        System.out.println("=========");
        // remove()返回本次移除的元素
        Object e1 = blockingQueue.remove();
        Object e2 = blockingQueue.remove();
        Object e3 = blockingQueue.remove();
        // 队列中没有元素仍继续移除元素会抛出异常java.util.NoSuchElementException
        Object e4 = blockingQueue.remove();
    }

    // 有返回值，不抛出异常
    private static void returnOperation() {
        // 队列的大小为3
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // offer返回boolean值
        boolean flag1 = blockingQueue.offer("a");
        boolean flag2 = blockingQueue.offer("b");
        boolean flag3 = blockingQueue.offer("c");
        // offer添加元素超过队列的长度会返回false
        //boolean flag4 = blockingQueue.offer("d");
        // 获得队首元素
        System.out.println(blockingQueue.peek());
        System.out.println("=========");
        // poll()返回本次移除的元素
        Object poll1 = blockingQueue.poll();
        Object poll2 = blockingQueue.poll();
        Object poll3 = blockingQueue.poll();
        // 队列中没有元素仍继续移除元素会打印出null
        Object poll4 = blockingQueue.poll();
    }

    private static void blockingThread() throws InterruptedException {
        // 队列的大小为3
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // put没有返回值
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // put添加元素超过队列的长度会一直等待
        //blockingQueue.put("d");
        System.out.println("element take start!");
        // take()返回本次移除的元素
        Object take1 = blockingQueue.take();
        Object take2 = blockingQueue.take();
        Object take3 = blockingQueue.take();
        // 队列中没有元素仍继续移除元素会一直等待
        //Object take4 = blockingQueue.take();
        System.out.println("element take over!");
    }

    // 阻塞，超时等待
    private static void blockingTimedThread() throws InterruptedException {
        // 队列的大小为3
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // offer返回boolean值
        boolean flag1 = blockingQueue.offer("a");
        boolean flag2 = blockingQueue.offer("b");
        boolean flag3 = blockingQueue.offer("c");
        System.out.println("element offer wait start!");
        // offer添加元素超过队列的长度会返回false；并且等待指定时间后推出，向下执行
        boolean flag4 = blockingQueue.offer("d", 2, TimeUnit.SECONDS);
        System.out.println("element offer wait end!");
        // poll()返回本次移除的元素
        Object poll1 = blockingQueue.poll();
        Object poll2 = blockingQueue.poll();
        Object poll3 = blockingQueue.poll();
        System.out.println("element poll wait start!");
        // 队列中没有元素仍继续移除元素会打印出null，等待指定之间后退出。
        Object poll4 = blockingQueue.poll(2,TimeUnit.SECONDS);
        System.out.println("element poll wait end!");
    }
}
