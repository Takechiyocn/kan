package logic.container.collection.listbase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author moku
 */
public class LinkedListSummary {

    public static void main(String[] args) {

        List<String> list1 = new LinkedList<>() {{
            add("AA");
            add("BB");
            add("CC");
        }};

        List<String> list2 = new LinkedList<>() {{
            add("aa");
            add("bb");
            add("cc");
        }};

        // 合并list：间隔插入
        ListIterator<String> list1Iter = list1.listIterator();
        Iterator<String> list2Iter = list2.iterator();
        while (list2Iter.hasNext()) {
            if (list1Iter.hasNext()) {
                list1Iter.next();
            }
            list1Iter.add(list2Iter.next());
        }
        System.out.println(list1);

        // list2每间隔一个元素删除一个元素
        list2Iter = list2.iterator();
        while (list2Iter.hasNext()) {
            list2Iter.next();
            if (list2Iter.hasNext()) {
                list2Iter.next();
                list2Iter.remove();
            }
        }
        System.out.println(list2);

        // 批量操作bulk operation：删除list1中所有的list2元素
        list1.removeAll(list2);
        System.out.println(list1);

    }
}
