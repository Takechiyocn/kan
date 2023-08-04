package logic.interfacecustomize;

import java.util.Comparator;

/**
 * @description: 自定义接口实现comparator
 * @author: Kan
 * @date: 2021/2/28 0:14
 */
public class ArraysSortComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        // if length is equal
        if (o1.length() == o2.length()) {
            return o1.compareTo(o2);
        }
        // order by length
        return o1.length() - o2.length();
    }
}
