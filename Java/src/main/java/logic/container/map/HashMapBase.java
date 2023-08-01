package logic.container.map;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 采用散列(哈希算法)算法进行数据存储，因此数据无序存放
 *
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

        HashMap<String, Integer> map2 = new HashMap<>();
        System.out.println(map2.size());

        // HashMap由put维护键值对，应避免使用containsKey()方法
        // 未优化
        Map<String, List<Integer>> map3 = new HashMap<>();
        List<Integer> valueList;
        // containsKey：底层调用getNode()
        if (map3.containsKey("a")) {
            // get()：底层调用getNode()
            valueList = map3.get("a");
        } else {
            valueList = new ArrayList<>();
        }
        valueList.add(1);

        // 优化
        Map<String, List<Integer>> map4 = new HashMap<>();
        List<Integer> valueList2 = map4.get("a");
        if (null == valueList2) {
            valueList2 = new ArrayList<>();
        }
        valueList2.add(1);

        // 遍历
        HashMapLoop();
    }

    /**
     * 1. HashMap.keySet()
     * 2. HashMap.entrySet：最佳遍历方式
     * 3. lambda
     * 4. lambda简略形式
     *
     * @Params:[]
     * @Returns:void
     */
    private static void HashMapLoop() {
        Map<String, Integer> map = new HashMap<>() {{
            put("D", 10);
            put("C", 9);
            put("B", 8);
            put("A", 7);
        }};

        // 1. HashMap.keySet()
        Set<String> s = map.keySet();
        for (String k : s) {
            // value
            Integer v = map.get(k);
            System.out.println("Loop through keySet:" + k + ":" + v);
        }

        // 2. HashMap.entrySet：最佳遍历方式
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // key
            String k = entry.getKey();
            // value
            Integer v = entry.getValue();
            System.out.println("Loop through entrySet:" + k + ":" + v);
        }

        // 3. lambda
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer v) {
                System.out.println("Loop through lambda:" + s + ":" + v);
            }
        });

        // 4. lambda2
        map.forEach(
                (k, v) ->
                        System.out.println("Loop through lambda2:" + k + ":" + v)
        );
    }
}
