package container.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * Hashtable是早期的字典实现类，可以方便的实现数据的查询
 * @ClassName HashtableBase
 * @Author moku
 * @Date 2022/11/19 1:45
 * @Version 1.0
 */
public class HashtableBase {

    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>(){{
            put("c", 1);
            put("b", 2);
            put("a", 3);
        }};

        // 输出：{b=2, a=3, c=1}
        // 无序，说明Hashtable中数据采用散列存储
        System.out.println(map);
    }
}
