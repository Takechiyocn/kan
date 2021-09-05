package interfacecustomize;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/28 0:37
 */
@Slf4j
public class ArraysComparableTest {
    public static void main(String[] args) {
//        ArraysComparable[] arraysComparables = new ArraysComparable[3];
//        arraysComparables[0] = new ArraysComparable(3000);
//        arraysComparables[1] = new ArraysComparable(2000);
//        arraysComparables[2] = new ArraysComparable(5000);
        ArrayList<ArraysComparable> arrayList = new ArrayList<>();
        arrayList.add(new ArraysComparable(3000));
        arrayList.add(new ArraysComparable(2000));
        arrayList.add(new ArraysComparable(5000));
        arrayList.forEach(x -> log.info("Before:" + x.geSalary()));
        // ArrayList to arrays
        ArraysComparable[] arrays = arrayList.toArray(new ArraysComparable[0]);
        // Array(数组)的全部变量(此处为ArraysComparable类型变量)必须实现Comparable接口(覆盖函数：compareTo)
        Arrays.sort(arrays);
        // Arrays to arrayList
        arrayList = new ArrayList<>(Arrays.asList(arrays));
        arrayList.forEach(x -> log.info("After:" + x.geSalary()));

    }
}
