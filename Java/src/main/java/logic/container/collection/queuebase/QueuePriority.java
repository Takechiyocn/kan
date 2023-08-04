package logic.container.collection.queuebase;

import java.time.LocalDate;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列priority queue：一种允许高效删除最小值/元素(优先级最高)的集合，默认从小到大排序
 *   1. 调用remove/poll方法，总会删除当前优先级队列中最小的元素（优先级队列并没有对所有元素进行排序） -> 优先级最高的1被删除
 *   2. 优先级队列：使用堆heap（可自我调整的二叉树） 习惯于将1设为最高优先级
 *                 对数执行添加add和删除remove操作，可让最小元素移动到根
 *   3. 可保存实现了Comparable接口的类对象
 *       也可保存在构造器中提供的Comparator对象(自定义Comparator比较器)
 *        -> 因为树集是有序的，所以需要比较器实现
 *   4. 常用于任务调度
 * PriorityQueue添加元素时并不是完全有序，因为数据结构是完全二叉树，添加元素时只将最小元素放在头部；故添加元素后若想获得有序元素，
 * 应使用remove/offer遍历该队列获取各个元素。删除亦是如此
 * Comparator实现时：
 *   // 从大到小
 *   return o2.compareTo(o1);
 *   // 从小到大(默认)
 *   return o1.compareTo(o2);
 *
 * @author moku
 *
 */
public class QueuePriority {

    public static void main(String[] args) {

        // 优先级队列：数字
        priorityQueueInteger();
        // 优先级队列：字符串
        priorityQueueString();
        // 优先级队列：对象
        priorityQueueObject();

        // 逆优先级队列：更改默认优先级方式(默认：值越小优先级越高)
        priorityQueueReverse();
    }

    private static void priorityQueueReverse() {
        Queue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        p.offer(0);
        p.offer(2);
        p.offer(5);
        p.offer(3);
        p.offer(6);
        p.offer(1);
        p.offer(4);
        p.offer(0);

        System.out.println("ReversePriorityQueue:" + p);
        while (!p.isEmpty()) {
            System.out.println("ReversePriorityQueue:" + p.remove());
        }
    }

    private static void priorityQueueObject() {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>() {{
            add(LocalDate.of(1906, 12, 9));
            add(LocalDate.of(1815, 12, 10));
            add(LocalDate.of(1903, 12, 3));
            add(LocalDate.of(1910, 6, 22));
        }};

        System.out.println("PriorityQueueObject:" + pq);
        while (!pq.isEmpty()) {
            System.out.println("PriorityQueueObject:" + pq.remove());
        }
    }

    private static void priorityQueueString() {
        PriorityQueue<String> pq = new PriorityQueue<>() {{
            add("C");
            add("b");
            add("a");
            add("B");
        }};

        System.out.println("PriorityQueueString:" + pq);
        while (!pq.isEmpty()) {
            System.out.println("PriorityQueueString:" + pq.remove());
        }
    }

    private static void priorityQueueInteger() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(0);
        pq.offer(2);
        pq.offer(6);
        pq.offer(0);
//        pq.add(5);
//        pq.add(0);
//        pq.add(2);
//        pq.add(6);
//        pq.add(0);

        // 完全二叉树导致添加元素时只将最小元素放在头部，部分有序
        System.out.println("PriorityQueueInteger:" + pq);
        while (!pq.isEmpty()) {
//            System.out.println("PriorityQueueInteger:" + pq.remove());
            System.out.println("PriorityQueueInteger:" + pq.poll());
        }
    }
}
