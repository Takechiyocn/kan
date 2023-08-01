package logic.jdk9feature;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ListSetMapOfMethod
 * @Description List、Set、Map接口的静态方法of：用于创建少量元素的集合、map实例
 *              特点：of方法返回的集合不可变，即不能增加元素/改变集合size
 * @Author moku
 * @Date 2022/11/25 11:02
 * @Version 1.0
 */
public class ListSetMapOfMethod {

    public static void main(String[] args) {

        // Set.of()
        Set<String> s = Set.of("a", "b", "c");
        // UnsupportedOperationException
//        s.add("d");
        System.out.println(s);

        // List.of()
        List<String> l = List.of("a", "b", "c");
        // UnsupportedOperationException
//        l.add("d");
        System.out.println(l);

        // Map.of
        Map<String, Integer> m = Map.of("a", 1, "b", 2);
        // UnsupportedOperationException
//        m.put("c", 3);
        System.out.println(m);
    }
}
