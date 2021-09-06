package collection.listbase.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/1 0:38
 */
public class ArrayListInitialization {
    // constructor
    public ArrayListInitialization() {
    }

    // 1. ArrayList<T>(Arrays.asList(arrays))
    public static ArrayList<String> initialArrayList() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        return arrayList;
//        return new ArrayList<>(Arrays.asList("A", "B", "C"));
    }


    // 2. new ArrayList<String>();
    //   add
    public static ArrayList<String> initialArrayList2() {
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("A");
        arrayList2.add("B");
        arrayList2.add("C");
        return arrayList2;
    }

    // 3. new ArrayList<String>(){{add("A")}};
    // 匿名数组列表
    public static ArrayList<String> initialArrayList3() {
        ArrayList<String> arrayList3 = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
        }};
        return arrayList3;
    }
}

