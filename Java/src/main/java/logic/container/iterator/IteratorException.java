package logic.container.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 迭代器并发修改异常
 */
public class IteratorException {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>() {{
            add("s1");
            add("s2");
            add("s3");
        }};

        ListIterator<String> iter1 = list.listIterator();
        // 初始化时，iter2迭代器链表结构已经确定，即iter2.next()指向固定位置，hasNext()也针对next的位置
        ListIterator<String> iter2 = list.listIterator();
        iter1.next();
//        iter1.remove();
        // hasNext()在iter2初始化时已经确定有元素（因为iter2内容已经设置）
        if (iter2.hasNext()) {
            // ConcurrentModificationException异常
            // 迭代器维护独立计数值，每个迭代器方法开始出检查自己改写操作的计数值是否与集合的改写操作计数值一致
            // 不一致就抛出ConcurrentModificationException异常
//            iter2.next();
        }

        // 迭代器并发修改检测值跟踪结构性修改，如添加、删除元素
        // 不针对set方法（set方法不视为结构性修改）
        iter2.next();
        iter1.set("s1-0");
        System.out.println("Iterator1 modified:" + list.toString());
        iter2.set("s1-1");
        System.out.println("Iterator1 modified:" + list.toString());

    }
}
