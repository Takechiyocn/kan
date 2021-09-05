package interfacecustomize;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/28 0:17
 */
@Slf4j
public class ArraysSortComparatorTest {
    public static void main(String[] args) {
        // Comparator接口的实例比较：
        // 与Arrays.sort(<T> o)：（实现了比较器Comparable接口）相比，Comparator操作对象是比较器对象
        Comparator<String> comp = new ArraysSortComparator();
        if (comp.compare("123", "1234") > 0){
            log.info("first is more long");
        } else {
            log.info("Second is more long");
        }

        // Arrays.sort(T[] a, Comparator<? super T> c):实现了比较器(Comparator)接口
        String[] friends = {"Peter","Paul","Mary"};
        for (String s : friends) {
            log.info("Before compare:" + s);
        }
        Arrays.sort(friends,new ArraysSortComparator());
        for (String s : friends) {
            log.info("After compare:" + s);
        }
    }
}
