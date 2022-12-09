package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashMapBase
 * @Description TODO
 * @Author moku
 * @Date 2022/11/22 22:31
 * @Version 1.0
 */
public class HashMapBase {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        // key重复发生覆盖
        map.put("one", 11);
        map.put("zero", null);
        map.put(null, 3);

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

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("A",2);
        System.out.println(map.size());
        System.out.println(map2.size());
    }
}
