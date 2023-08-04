package util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName DeleteDuplication
 * @Description
 * @Author moku
 * @Date 2023/2/12 9:25
 * @Version 1.0
 */
public class DeleteDuplication {
    public static void main(String[] args) {

        // 1. LinkedHashSet:去重并保持数据的顺序
        linkedHashSetDeleteDuplication();

        // 2. HashSet:无法去重，可作为去重判断条件
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        hashSetDeleteDuplication(numbersList);
        System.out.println("HashSet" + numbersList);

        // 3. stream去重
        streamDeleteDuplication();

        // 4. List的contains方法遍历
        ArrayList<Integer> numbersList2 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        listContainsDuplication(numbersList2);
        System.out.println("ListContains" + numbersList2);

        // 5. 双重for循环
        forLoopDuplication();
    }

    private static void forLoopDuplication() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        System.out.println("ForLoop" + numbersList);
        List<Integer> listWithoutDuplications = numbersList.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < numbersList.size(); i++) {
            for (int j = 0; j < numbersList.size(); j++) {
                if (i != j && numbersList.get(i) == numbersList.get(j)) {
                    numbersList.remove(numbersList.get(j));
                }
            }
        }
        System.out.println("ForLoop" + listWithoutDuplications);
    }

    private static void listContainsDuplication(List<Integer> numbersList2) {
        List<Integer> result = new ArrayList<>(numbersList2.size());
        for (Integer i : numbersList2) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }
        numbersList2.clear();
        numbersList2.addAll(result);
    }


    private static void streamDeleteDuplication() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        System.out.println("Stream" + numbersList);
        List<Integer> listWithoutDuplications = numbersList.stream().distinct().collect(Collectors.toList());
        System.out.println("Stream" + listWithoutDuplications);
    }

    private static void hashSetDeleteDuplication(List<Integer> numbersList) {
        HashSet<Integer> set = new HashSet<>(numbersList.size());
        List<Integer> result = new ArrayList<>(numbersList.size());
        for ( Integer i : numbersList) {
            if (set.add(i)) {
                result.add(i);
            }
        }
        numbersList.clear();
        numbersList.addAll(result);
    }

    private static void linkedHashSetDeleteDuplication() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        System.out.println("LinkedHashSet" + numbersList);
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbersList);
        ArrayList<Integer> listWithoutDuplications = new ArrayList<>(hashSet);
        System.out.println("LinkedHashSet" + listWithoutDuplications);
    }
}
