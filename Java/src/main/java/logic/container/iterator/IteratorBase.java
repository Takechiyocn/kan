package logic.container.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;

/**
 * 集合
 */
public class IteratorBase {

    public static void main(String[] args) {

        Collection<String> coll = new ArrayList<>() {{
            add("s1");
            add("s2");
            add("s3");
            add("s4");
            add("s5");
        }};

        // 集合基本接口：
        //  1. Collection
        //     集（Set）的add方法不允许增加重复元素 -> 要重新定义集的equals方法和hashCode方法
        //  2. Map

        // List
        // 特点：有序集合ordered collection
        // 访问：迭代器顺序访问，索引随机访问

        // 迭代器访问list：顺序访问
        // 适合：链表支持的集合（因为随机访问很慢），如LinkedList
        listIteratorAccess(coll);

        // 索引访问list：随机访问random access
        // 适合：数组支持的有序集合，如ArrayList
        listIndexAccess((ArrayList<String>) coll);

        // 判断集合是否支持高效的随机访问
        if (coll instanceof RandomAccess) {
            System.out.println("Support random access!");
        } else {
            System.out.println("Not support random access!");
        }
    }

    /**
     * 迭代器顺序访问
     *
     * @param coll
     */
    public static void listIteratorAccess(Collection<String> coll) {

        Iterator<String> iter = coll.iterator();
        //  容器元素遍历1：迭代器
        //  与其他非Java迭代器区别：
        //     其他：如C++，迭代器根据数组索引建模。即给定迭代器，可查看指定位置上元素，类似给定数组索引i，可查看数组元素a[i]
        //     Java:顺序迭代，即只能顺序查看
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println("element: " + element);
        }

        //  容器元素遍历2：增强for循环(带有迭代器的循环:编译器优化成迭代器遍历)
        //              -> for each循环可与任何实现了Iterable接口的对象一起工作
        //                 interface iterable { Iterator<E> iterator(); }
        for (String element : coll) {
            System.out.println("element by for each: " + element);
        }

        //  容器元素遍历3：lambda表达式
        // iter迭代器在迭代器中已经迭代到末尾，故下列语句不输出元素
        iter.forEachRemaining(element -> System.out.println("element by lambda: " + element));
        // 建立新的匿名迭代器：coll.iterator()
        coll.iterator().forEachRemaining(element -> System.out.println("element by lambda: " + element));
        // foreach：Iterable接口方法，所有集合(List，Set，Queue)均可使用
        coll.forEach(element -> System.out.println("element by foreach lambda: " + element));

        // 容器元素删除：顺序删除迭代元素，然后遍历删除后剩下的元素
        Iterator<String> iter2 = coll.iterator();
        iter2.next();
        iter2.next();
        iter2.remove();
        iter2.forEachRemaining(element -> System.out.println("element after remove: " + element));
    }

    /**
     * 索引访问list：随机访问random access
     *
     * @param coll
     */
    public static void listIndexAccess(ArrayList<String> coll) {
        for (int i = 0; i < coll.size(); i++) {
            System.out.println("element by lambda: " + coll.get(i));
        }
    }
}
