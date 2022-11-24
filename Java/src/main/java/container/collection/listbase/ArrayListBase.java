package container.collection.listbase;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组列表ArrayList：封装了动态分配的对象数组
 * 动态数组：也可使用Vector
 * 特点：1.Vector类的所有方法都是同步(synchronized同步处理)
 *        数组列表方法不同步
 *      2. Vector:可以由两个线程安全访问一个Vector对象
 *                如果由一个线程访问Vector，代码同步操作需要耗费大量时间
 *  使用条件：需要同步时使用Vector
 *           不需要同步时使用数组列表
 *
 * @author moku
 */
public class ArrayListBase {

    public static void main(String[] args) {
        List<String> all = new ArrayList<>() {{
            add("one sheep");
            add("one sheep");
            add("two sheep");
        }};
        System.out.println("Elements in list:" + all.size());
        all.remove("two sheep");
        System.out.println("Elements in list after remove:" + all.size());
        // 获取指定索引元素
        System.out.println("Index(1):" + all.get(1));
        System.out.println(all);

        // 删
        removeArrayList();
        
        // 子列表：字列表修改影响列表
        subListArrayList();
        
        // 交集
        retainArrayList();
    }

    private static void subListArrayList() {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("b");
            add("c");
        }};
        List<String> subList = list.subList(1, 3);
        System.out.println("subList : " + subList);
        System.out.println("list : " + list);

        // 在子列表中添加元素后，增加的元素也会反映到父列表list中的特定位置
        subList.add("f");
        System.out.println("subList : " + subList);
        System.out.println("list : " + list);
        subList.remove(0);
        System.out.println("subList : " + subList);
        System.out.println("list : " + list);
    }

    /**
     * list.containAll:保留相同元素—交集，并且将交集保存在当前集合中
     * @Params:[]
     * @Returns:void
     */
    private static void retainArrayList() {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("b");
            add("c");
        }};
        List<String> list2 = new ArrayList<>() {{
            add("1");
            add("a");
            add("c");
            add("2");
        }};

        // 保留相同元素—交集，并且将交集保存在当前集合中
        System.out.println("list.containAll before : " + list);
        list.retainAll(list2);
        System.out.println("通过list求（list和list2）的交集 : " + list);
        System.out.println("list2 : " + list2);
        list2.retainAll(list);
        System.out.println("通过list2求（list和list2）的交集 : " + list2);
    }

    /**
     * 1. list.remove(object)
     * 2. list.remove(index)
     * @Params:[]
     * @Returns:void
     */
    private static void removeArrayList() {
        List<String> list = new ArrayList<>() {{
            add("sheep");
            add("cow");
            add("dog");
            add("sheep");
        }};
        System.out.println("Before remove:" + list);

        // 1. list.remove(object)：只能删除重复元素中的第一个，无法删除所有重复元素
        list.remove("sheep");
        System.out.println("After remove(object):" + list);

        // 2. list.remove(index)
        list.remove(1);
        System.out.println("After remove(index):" + list);

        // 对于List和Set集合，标准for循环和增强for循环要避免使用remove()方法
        // 由于remove()会导致集合size变小，随着index增大，会变成间隔删除元素
        List<String> list2 = new ArrayList<>() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
        }};
        System.out.println("Before remove by for:" + list2);

        for (int i = 0; i < list2.size(); i++) {
            list2.remove(i);
        }
        System.out.println("After remove by for:" + list2);

        // 并发修改异常ConcurrentModificationException：
        //   因为增强for循环底层转换为迭代器遍历，所以迭代器中remove、add(HashMap中put)会产生相同异常
        for (String s : list2) {
//            list2.remove(s);
        }
        System.out.println("After remove by for:" + list2);
    }
}
