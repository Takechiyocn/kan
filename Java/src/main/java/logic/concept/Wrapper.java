package logic.concept;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 *
 * Autoboxing：自动装箱：编译器自动将变量类型转换为符合类型的过程，即转换为包装器wrapper类型的过程
 * 自动拆箱：自动装箱逆过程
 * 如果对象包装器类定义为final类型，亦即一旦构造了包装器对象，则不允许更改包装在其中的值
 *
 * 包装器类中有静态内部类IntegerCache，里面有个cache[]表示Integer常量池，即包装类可共用最大缓存对象值
 *   Byte/Short/Integer/Long：-128~127
 *   Float/Double没有常量池
 *   Character：0~127
 */
@Slf4j
public class Wrapper {
    public static void main(String[] args) {
        Integer a1 = 127;
        Integer a2 = 127;
        Integer b1 = 128;
        Integer b2 = 128;
        Character c1 = 127;
        Character c2 = 127;
        Character d1 = 128;
        Character d2 = 128;
        System.out.println(a1.equals(c1));
        // == 应用于对象包装器：比较两个包装器是否指向同一存储区域，结果取决于包装类常量池大小
        System.out.println(a1 == a2);
        System.out.println(b1 == b2);
        System.out.println(c1 == c2);
        System.out.println(d1 == d2);
        // 该处equals被Integer类重写为比较包装器对象值
        System.out.println("Use equals:" + a1.equals(a2));
        System.out.println("Use equals:" + b1.equals(b2));
        System.out.println("Use equals:" + c1.equals(c2));
        System.out.println("Use equals:" + d1.equals(d2));

        // 自动装箱
        ArrayList<Integer> aInt = new ArrayList<>() {{
            add(1); // Integer.valueOf(1)
            add(2); // Integer.valueOf(3)
            add(3); // Integer.valueOf(3)
        }};
//         i = Integer.valueOf(n);
        // 自动拆箱
        for (int i : aInt) {
            log.info("boxing:" + i);
        }

        int i = 200;
        Integer j = new Integer(200);
        // true：j自动拆箱后再进行值比较
        System.out.println(i == j);
    }
}