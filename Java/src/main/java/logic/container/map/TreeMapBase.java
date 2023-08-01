package logic.container.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName TreeMapBase
 * @Author moku
 * @Date 2022/11/19 1:51
 * @Version 1.0
 */
public class TreeMapBase {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>() {{
           put("c", 1);
           put("b", 2);
           put("a", 3);
        }};

        // 输出：{a=3, b=2, c=1}
        // String类实现了Comparable接口，根据Key编码排序
        System.out.println(map);
    }
}
