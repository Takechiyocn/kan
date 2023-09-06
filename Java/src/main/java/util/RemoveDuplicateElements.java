package util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * RemoveDuplicateElements
 *
 * @author moku
 * @date 2023/2/12 9:25:38
 * @version 1.0
 */
public class RemoveDuplicateElements {
    public static void main(String[] args) {

        // 1. 双重for循环去重
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 6, 6, 1, 1, 2, 3, 3, 3, 4, 5, 7, 8));
        System.out.println("ForLoop Before:" + list);
        removeDuplicateElementsWithForLoop(list);
        System.out.println("ForLoop After:" + list);


        // 2. List.contains()去重
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 6, 6, 1, 1, 2, 3, 3, 3, 4, 5, 7, 8));
        System.out.println("List.contains() Before:" + list2);
        removeDuplicateElementsWithContains(list2);
        System.out.println("List.contains() After:" + list2);

        // 3. stream去重
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 6, 6, 1, 1, 2, 3, 3, 3, 4, 5, 7, 8));
        System.out.println("Stream Before:" + list3);
        list3 = removeDuplicateElementsWithStream(list3);
        System.out.println("Stream After:" + list3);

        // 4. LinkedHashSet:去重并保持数据的原始顺序
        List<Integer> list4 = new ArrayList<>(Arrays.asList(6, 6, 6, 1, 1, 2, 3, 3, 3, 4, 5, 7, 8));
        System.out.println("LinkedHashSet Before:" + list4);
        list4 = removeDuplicateElementsWithLinkedHashSet(list4);
        System.out.println("LinkedHashSet After:" + list4);

        // 5. HashSet:无法去重，可作为去重判断条件
        List<Integer> list5 = new ArrayList<>(Arrays.asList(6, 6, 6, 1, 1, 2, 3, 3, 3, 4, 5, 7, 8));
        System.out.println("HashSet Before:" + list5);
        removeDuplicateElementsWithHashSet(list5);
        System.out.println("HashSet After:" + list5);
    }


    /**
     * 双重for循环去重
     *
     * @param list
     * @return void
     */
    private static <E> void removeDuplicateElementsWithForLoop(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i) == list.get(j)) {
                    list.remove(list.get(j));
                }
            }
        }
    }

    /**
     * List.contains()去重
     *
     * @param list
     * @return void
     */
    private static <E> void removeDuplicateElementsWithContains(List<E> list) {
        List<E> result = new ArrayList<>();
        for (E e : list) {
            if (!result.contains(e)) {
                result.add(e);
            }
        }
        list.clear();
        list.addAll(result);
    }

    /**
     * stream去重:.sorted自然顺序
     *
     * @param list
     * @return java.util.List<E>
     */
    private static <E> List<E> removeDuplicateElementsWithStream(List<E> list) {
        // 值类型特点：按值传递
        // 不论基本类型还是引用类型，传递都是原数据的一个副本
        //   传递引用时，副本和原始数据指向同一个堆上的数据区域
        // 以下处理使副本list指向新的引用
        // list = list.stream().distinct().collect(Collectors.toList());

        // 默认自然排序
        return list.stream().distinct().sorted().collect(Collectors.toList());

        // TODO:倒序
//        return list.stream().distinct().sorted().collect(Collectors.toList());
    }

    /**
     * LinkedHashSet:去重并保持数据的原始顺序
     *
     * @param list
     * @return java.util.List<E>
     */
    private static <E> List<E> removeDuplicateElementsWithLinkedHashSet(List<E> list) {
//        Set<E> hashSet = new LinkedHashSet<>(list);
        return new ArrayList<>(new LinkedHashSet<>(list));
    }


    /**
     * HashSet无法去重，可作为去重判断条件(set.add(e):set中元素不存在则返回true)
     *
     * @param list
     * @return void
     */
    private static <E> void removeDuplicateElementsWithHashSet(List<E> list) {
        Set<E> set = new HashSet<>();
        List<E> result = new ArrayList<>(list.size());
        for (E e : list) {
            // 如果set中元素不存在则返回true并将该元素添加到set
            if (set.add(e)) {
                result.add(e);
            }
        }
        list.clear();
        list.addAll(result);
    }
}
