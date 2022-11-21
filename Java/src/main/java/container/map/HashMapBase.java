package container.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用散列(哈希算法)算法进行数据存储，因此数据无序存放
 * @ClassName HashMapBase
 * @Author moku
 * @Date 2022/11/19 1:36
 * @Version 1.0
 */
public class HashMapBase {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>() {{
            put("one", 1);
            put("two", 2);
            // key重复发生覆盖
            put("one", 11);
            put("zero", null);
            put(null, 3);
        }};

        // key重复时，获取最新value
        System.out.println("key重复时，获取最新value：" + map.get("one"));
        // 允许key或者value为空
        System.out.println("允许key为空：" + map.get(null));
        System.out.println("允许value为空：" + map.get("zero"));
        // Map中不存在key，返回null
        System.out.println("Map中不存在key时：" + map.get("three"));

        // put返回值：
        //  1. Map中key不存在时，返回null
        //  2. Map中key存在时，返回旧value
        System.out.println("Map中key不存在时，返回：" + map.put("four", 4));
        // 输出：4
        System.out.println("Map中key存在时，返回旧value：" + map.put("four", 44));

        Map<String, Integer> map2 = new HashMap<>();
        System.out.println(map2.size());
    }
}