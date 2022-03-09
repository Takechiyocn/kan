package collection.listbase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链表
 * 特点：1.自然有序的集合ordered collection
 *      2.高效插入和删除元素
 *      3.不支持快速随机访问
 */
public class LinkedListBase {

    public static void main(String[] args) {

        List<String> staff = new LinkedList<>() {{
            add("s1");
            add("s2");
            add("s3");
            add("s4");
            add("s5");
        }};

        // ListIterator.nex,ListIterator.previous
        linkedListElementVisit(staff);

        // 链表集合：删除/追加 指定位置元素 更高效
        // 数组集合：访问 指定位置元素更高效
//         LinkedList.remove("s3");
        linkedListDeleteVisited0(staff);

        // Iterator.remove()
        linkedListDeleteVisited(staff);

        // ListIterator.remove()
        linkedListDeleteVisited2(staff);

        // 追加元素方法：
        //   1. LinkedList.add追加元素到链表尾部
        linkedListAddToEnd(staff);
        //   2. Iterator子集：ListIterator
        linkedListAddToAfterNext(staff);

        // 替换链表元素：LinkedList.set
        linkedListReplaceVisited(staff);

        // LinkedList.contains()
        System.out.println("LinkedList.contains(): " + staff.contains("s4"));

        // LinkedList.get()
        // 链表随机访问:效率低(内部实现：从头开始，越过n-1个元素)
        // get内部微小优化：如果index大于size()/2,从列表尾端开始搜索
        System.out.println("LinkedList.get()" + staff.get(4));

        // LinkedList索引:ListIterator.previousIndex,ListIterator.nextIndex
        linkedListIndex(staff);

    }

    /**
     * ListIterator.previousIndex
     * ListIterator.nextIndex
     * 特点：效率高，因为迭代器保持着当前位置的计数值
     *
     * @param staff
     */
    private static void linkedListIndex(List<String> staff) {

        ListIterator<String> listIter = staff.listIterator();

        listIter.next();
        // 返回下一次调用next方法时返回元素的整数索引
        int nextIndex = listIter.nextIndex();
        System.out.println("ListIterator.nextIndex: " + nextIndex);

        // 返回下一次调用previous方法时返回元素的整数索引
        int preIndex = listIter.previousIndex();
        System.out.println("ListIterator.previousIndex: " + preIndex);

        // 返回一个迭代器LinkedList.listIterator(n)：该迭代器指向索引为n的元素前面的位置(即迭代器当前位置为：元素n-1和n之间)
        // 效率低
        System.out.println("LinkedList.listIterator(n):" + staff.listIterator(1).next());
        System.out.println("LinkedList.get(n):" + staff.get(1));

    }

    /**
     * LinkedList.remove
     *
     * @param staff
     */
    private static void linkedListDeleteVisited0(List<String> staff) {
        // 当前集合元素：[s1, s2, s3, s4, s5]
        staff.remove("s5");
        // 当前集合元素：[s1, s2, s3, s4]
        forEachElementInList(staff, "After LinkedList.remove(), list");
    }


    /**
     * ListIterator.set:只能替换next()或者previous()最后访问过的元素
     *
     * @param staff
     */
    private static void linkedListReplaceVisited(List<String> staff) {
        ListIterator<String> listIter = staff.listIterator();

        // 当前集合元素：[sa1, sa2, sa30, sa3, s4, s6]
        // 当前迭代器位置：“sa1”之前
        listIter.next();
        // 当前迭代器位置：“sa1-replaced”和"sa2"之间
        listIter.set("sa1-replaced");
        forEachElementInList(staff, "After ListIterator.set() with next(), list");

        // 当前集合元素：[sa1-replaced, sa2, sa30, sa3, s4, s6]
        // 当前迭代器位置：“sa1-replaced”和"sa2"之间
        listIter.next();
        // 当前迭代器位置：“sa2”和"sa30"之间
        listIter.set("sa2-replaced");
        forEachElementInList(staff, "After ListIterator.set() with next(), list");

        // 当前集合元素：[sa1-replaced, sa2-replaced, sa30, sa3, s4, s6]
        // 当前迭代器位置：“sa2-replaced”和"sa30"之间
        listIter.previous();
        // 当前迭代器位置：“sa1-replaced”和"sa2-replaced"之间
        // previous:返回往前遍历过的元素:sa2-replaced
        listIter.set("sa2-replaced2");
        // 当前迭代器位置："s2-add third time"和"s3-replaced second time"之间
        forEachElementInList(staff, "After ListIterator.set() with previous(), list");
    }

    /**
     * ListIterator.add:追加元素到下一个next()返回的元素前面或者previous()返回元素的后面
     *
     * @param staff
     */
    private static void linkedListAddToAfterNext(List<String> staff) {
        // Iterator没有add方法原因：对于自然有序的集合由迭代器添加元素到指定位置才有意义
        //                        而集(Set)类型元素无序，所以在Iterator中实现add方法没有意义。
        ListIterator<String> listIter = staff.listIterator();

        // 当前集合元素：[sa1, s4, s6]
        // 迭代器当前位置：sa1之前
        listIter.next();
        // 可连续多次调用add
        // 迭代器当前位置：sa1和s4之间
        listIter.add("sa2");

        // 当前集合元素：[sa1, sa2, s4, s6]
        // 迭代器当前位置：sa2和s4之间
        // 插入元素位置：下一个next返回元素(s4)之前或者previous返回元素(sa2)之后
        listIter.add("sa3");

        // 当前集合元素：[sa1, sa2, sa3, s4, s6]
        // 迭代器当前位置：sa3和s4之间
        forEachElementInList(staff, "After ListIterator.add() with next(), list");

        // 当前集合元素：[sa1, sa2, sa3, s4, s6]
        // 迭代器当前位置：sa3和s4之间
        // previous:返回往前遍历过的元素:sa3
        listIter.previous();
        // 迭代器当前位置：sa2和sa3之间
        // 插入元素位置：下一个next返回元素(sa3)之前或者previous返回元素(sa2)之后，跟上面那个previous处理没有关系
        listIter.add("sa30");

        // 当前集合元素：[sa1, sa2, sa3, s4, s6]
        // 迭代器当前位置：sa4和s4之间
        forEachElementInList(staff, "After ListIterator.add() with previous(), list");
    }

    /**
     * LinkedList.add:追加元素到链表尾部
     *
     * @param staff
     */
    private static void linkedListAddToEnd(List<String> staff) {
        // 当前集合元素：[sa1, s4]
        //   1. LinkedList.add追加元素到链表尾部
        staff.add("s6");
        // 当前集合元素：[sa1, s4, s6]
        forEachElementInList(staff, "After LinkedList.add(), list");
    }

    /**
     * ListIterator.remove:删除且只能删除next()或者previous()最后访问过的元素
     *
     * @param staff
     */
    private static void linkedListDeleteVisited2(List<String> staff) {
        ListIterator<String> listIter = staff.listIterator();

        // 当前集合元素：[s1, s3, s4]
        // 当前迭代器位置："s1"之前
        listIter.next();
        listIter.remove();
        forEachElementInList(staff, "After ListIterator.remove() with next(), List");

        // 当前集合元素：[s3, s4]
        // 当前迭代器位置："s3"之前
        listIter.next();
        // 当前迭代器位置："s3"和"s4"之间
        // 遍历元素：s3
        listIter.previous();
        // 当前迭代器位置："s3"之前
        listIter.remove();
        forEachElementInList(staff, "After ListIterator.remove() with previous(), List");

        // 不能连续多次调用remove，以下将报错
//        listIter.remove();

        // ***remove：next或者previous处理之后，没有使用add方法时才能使用***
        //  -> 推测：add方法之后，迭代器位置不确定，即迭代器当前状态不明(上述add后的当前迭代器位置都是想定的)
        // 当前集合元素：[s4]
        // 当前迭代器位置："s4"之前
        listIter.add("sa1");
        // 当前迭代器位置："s4"之前
        // 不能remove未经过next或previous访问过得元素，以下将报错
//        listIter.remove();
    }

    /**
     * Iterator.remove:删除且只能删除next最后访问过的元素，其他操作后remove未定义即unspecified
     * Iterator抽象方法：
     * hasNext();
     * next();
     * remove;
     * forEachRemaining(); -> 遍历迭代器最后访问过的元素以后的元素
     *
     * @param staff
     */
    private static void linkedListDeleteVisited(List<String> staff) {
        Iterator<String> iter = staff.iterator();
        iter.next();
        String second = iter.next();

        // 当前集合元素：[s1, s2, s3]
        // 删除最后访问的元素
        iter.remove();
        // 当前集合元素：[s1, s3]

        // 不能连续多次调用remove，以下将报错
//        iter.remove();
        forEachElementInList(staff, "After Iterator.remove(), List");
    }


    /**
     * ListIterator.next():返回访问过的元素
     * ListIterator.previous():返回访问过的元素
     *
     * @param staff
     */
    private static void linkedListElementVisit(List<String> staff) {
        // 当前集合元素：[s1, s2, s3, s4, s5]
        ListIterator<String> listIter = staff.listIterator();
        // 迭代器当前位置：s1之前
        String nextElement = listIter.next();
        System.out.println("ListIterator.next() = " + nextElement);
        // 访问剩下元素
        forEachRemainingCustomize(listIter, "After ListIterator.next(), Remaining List");

        // 当前集合元素：[s1, s2, s3]
        ListIterator<String> listIter2 = staff.listIterator();
        // 迭代器当前位置：s1之前
        listIter2.next();
        // 迭代器当前位置：s1和s2之间
        String previousElement = listIter2.previous();
        // 迭代器当前位置：s1之前
        System.out.println("ListIterator.previous() = " + previousElement);
        // 访问剩下元素
        forEachRemainingCustomize(listIter2, "After ListIterator.previous(), Remaining List");
        // 实例方法引用
        staff.forEach(System.out::println);
    }

    /**
     * 访问迭代器后集合剩下元素
     *
     * @param listIter
     */
    public static void forEachRemainingCustomize(ListIterator<String> listIter, String desc) {
        iteratorElement(listIter, desc);
    }

    /**
     * 遍历List所有元素
     *
     * @param staff
     * @param desc
     */
    private static void forEachElementInList(List<String> staff, String desc) {
        System.out.println(desc + staff.toString());
    }

    /**
     * 遍历指定迭代器的所有元素
     *
     * @param iter
     * @param desc
     */
    public static void iteratorElement(Iterator<String> iter, String desc) {

//                iter.forEachRemaining(e -> {
//            // TODO:访问iter
//            if (iter.hasNext()) {
//                System.out.print(e + ",");
//            } else {
//                System.out.println(e + "]");
//            }
//        });

        System.out.print(desc + "[");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }
}
