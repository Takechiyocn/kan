package container.collection.queuebase;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 优先级队列priority queue：一种允许高效删除最小元素的集合
 *   1. 调用remove方法，总会删除当前优先级队列中最小的元素（优先级队列并没有对所有元素进行排序） -> 优先级最高的1被删除
 *   2. 优先级队列：使用堆heap（可自我调整的二叉树） 习惯于将1设为最高优先级
 *                 对数执行添加add和删除remove操作，可让最小元素移动到根
 *   3. 可保存实现了Comparable接口的类对象
 *       也可保存在构造器中提供的Comparator对象(自定义Comparator比较器)
 *        -> 因为树集是有序的，所以需要比较器实现
 *   4. 常用于任务调度
 *
 * @author moku
 *
 */
public class QueuePriority {

    public static void main(String[] args) {

        // TODO：优先级队列 排序算法
        PriorityQueue<LocalDate> pq = new PriorityQueue<>() {{
           add(LocalDate.of(1906,12,9));
           add(LocalDate.of(1815,12,10));
           add(LocalDate.of(1903,12,3));
           add(LocalDate.of(1910,6,22));
        }};

        System.out.println(pq);
        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
