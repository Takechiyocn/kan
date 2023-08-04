package logic.container.collection.queuebase;

import java.util.*;

/**
 * 队列:接口与实现分离(先进先出)
 *   接口：Queue<E>
 *   实现：
 *     a. 循环数组。高效，循环数组是一个有界集合，即容量有限。
 *     b. 链表。容量无限。
 */
public class QueueBase {

    public static void main(String[] args) {

        Queue<String> el = new LinkedList<>();
        // 尾端插入元素
        //  a. add:列表满了，抛出异常NoSuchElementException
        //  b. offer:列表满了，返回false
        el.add("e1");
        el.add("e2");
        el.add("e3");
        // 尾端插入元素
        el.offer("e4");
        System.out.println("after add/offer:" + el);

        // 前端删除元素：
        //  a. remove:列表为空，抛出异常NoSuchElementException
        //  b. poll:列表为空，返回null
        System.out.println("delete by remove:" + el.remove());
        System.out.println("delete by poll:" + el.poll());
        System.out.println("删除元素后：" + el);

        // 查找元素:从表前端
        //  a. element:列表为空，抛出异常NoSuchElementException
        //  b. peek:列表为空，返回null
        System.out.println("find by element:" + el.element());
        System.out.println("当前元素：" + el);
        System.out.println("find by peek:" + el.peek());
        System.out.println("当前元素：" + el);

        el.poll();
        el.poll();
        System.out.println("空队列poll() delete：" + el.poll());
        System.out.println("空队列peek() find：" + el.peek());
        // 查找元素: element, 列表为空，抛出异常NoSuchElementException
        System.out.println("空队列element() find:" + el.element());

        // LinkedList实现了Queue接口，Queue窄化了对LinkedList方法的访问
        // 即只能访问Queue接口中定义的方法，不能直接访问LinkedList的非Queue方法)
        Queue<LinkedList> el2 = new ArrayDeque<>();
        // 不能访问LinkedList中定义的方法
//        el2.get(0);
    }
}

