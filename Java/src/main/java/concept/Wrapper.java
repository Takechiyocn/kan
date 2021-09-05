package concept;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * Autoboxing：自动装箱：编译器自动将变量类型转换为符合类型的过程，即转换为包装器wrapper类型的过程
 * 自动拆箱：自动装箱逆过程
 * 对象包装器类定义为final类型，亦即一旦构造了包装器对象，则不允许更改包装在其中的值
 */
@Slf4j
public class Wrapper {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 1000;
        Integer d = 1000;
        // == 应用于对象包装器：比较两个包装器是否指向同一存储区域，结果不确定
        System.out.println(a == b);
        System.out.println(c == d);
        // 该处equals被Integer类重写为自比较包装器对象值
        System.out.println("Use equals:" + a.equals(b));
        System.out.println("Use equals:" + c.equals(d));

        // 自动装箱
        ArrayList<Integer> aInt = new ArrayList<>() {{
            add(1); // Integer.valueOf(1)
            add(2); // Integer.valueOf(3)
            add(3); // Integer.valueOf(3)
        }};
        // i = Integer(n).intValue()
        for (int i : aInt) {
            log.info("boxing:" + i);
        }
    }
}