package logic.clone;

import lombok.extern.slf4j.Slf4j;
import logic.superclass.Person;

import java.util.Arrays;

/**
 * @ClassName CloneBase
 * @Description 浅拷贝：浅拷贝只会复制原型对象，但不会复制它所引用的对象
 *                  在堆内存空间中开辟一块新地址来存储克隆/拷贝后的对象
 *                  原型对象中成员变量为以下时：
 *                    1. 值类型(基本类型)成员变量：属性复制给克隆对象：即修改拷贝不影响原对象
 *                    2. String类型成员变量：
 *                    2. 引用类型(类、数组、接口)：引用地址复制给克隆对象：即拷贝和原对象共享引用对象的地址
 *                       a. 修改引用对象属性值会影响全部(因为引用指向相同)
 *                       b. 修改引用对象指向(如person[0] = new Person("test"))只影响修改对象(因为引用指向发生变化)
 *              深拷贝：原型对象中的所有类型，无论是值类型还是引用类型，都复制一份给拷贝对象
 *                  在堆内存空间中开辟一块新地址来存储克隆/拷贝后的对象：修改拷贝不影响原对象
 * @Author moku
 * @Date 2022/11/16 13:18
 * @Version 1.0
 */
@Slf4j
public class CloneBase {

    public static void main(String[] args) {
        // 数组拷贝：Array.copyOf(int array)
        arrayCopyOfInt();
        // 数组拷贝：Array.copyOf(String array)
        arrayCopyOfString();
        // 数组拷贝：Array.copyOf(Object array)
        arrayCopyOfObject();
        // 数组拷贝：Array.copyOf(Object array)
        arrayCopyOfObject2();
        // clone
        cloneBase();
    }

    /**
     * Array.copyOf:浅拷贝
     *  1. 原型对象(拷贝元)成员变量：基本类型(值类型)int
     */
    public static void arrayCopyOfInt() {
        // 数组拷贝Arrays.copyOf：浅拷贝
        //  -> 创建的数组位于运行时数据区的堆中(线程共享)
        int[] a = new int[]{1, 2, 3};
        int[] b = Arrays.copyOf(a, a.length);

        System.out.println("Reference address:" + a);
        System.out.println("Reference address:" + b);

        System.out.println("Original" + Arrays.toString(a));
        System.out.println("New" + Arrays.toString(b));

        // 修改原型数组的第一个元素值
        a[0] = 10;

        System.out.println("============================================");
        System.out.println("Original" + Arrays.toString(a));
        System.out.println("New" + Arrays.toString(b));
    }

    /**
     * Array.CopyOf:浅拷贝
     *  2. 原型对象(拷贝元)成员变量：String
     *    -->String为不变对象
     */
    public static void arrayCopyOfString() {
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = Arrays.copyOf(s1, s1.length);

        System.out.println("Reference address:" + s1);
        System.out.println("Reference address:" + s2);

        System.out.println("Original" + Arrays.toString(s1));
        System.out.println("New" + Arrays.toString(s2));

        // 修改原型数组的第一个元素值
        s1[0] = "hhh";

        System.out.println("============================================");
        System.out.println("Original" + Arrays.toString(s1));
        System.out.println("New" + Arrays.toString(s2));
    }

    /**
     * Array.CopyOf:浅拷贝
     *  3. 原型对象(拷贝元)成员变量：Object
     *    -> 修改引用对象属性值
     */
    public static void arrayCopyOfObject() {
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 12);
        Person p3 = new Person("wangwu", 13);

        Person[] person1 = new Person[]{p1, p2, p3};
        Person[] person2 = Arrays.copyOf(person1, person1.length);

        System.out.println(person1);
        System.out.println(person2);

        System.out.println(Arrays.toString(person1));
        System.out.println(Arrays.toString(person2));

        // 浅拷贝2.a: 修改原型数组的第一个元素的属性值
        person1[0].setName("xiaoming");

        System.out.println("============================================");
        System.out.println(Arrays.toString(person1));
        System.out.println(Arrays.toString(person2));
    }

    /**
     * Array.CopyOf:浅拷贝
     *  4. 原型对象(拷贝元)成员变量：Object
     *    -> 修改引用对象指向
     */
    public static void arrayCopyOfObject2() {
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 12);
        Person p3 = new Person("wangwu", 13);

        Person[] person1 = new Person[]{p1, p2, p3};
        Person[] person2 = Arrays.copyOf(person1, person1.length);

        System.out.println(Arrays.toString(person1));
        System.out.println(Arrays.toString(person2));

        Person p4 = new Person("xiaohong", 14);
        // 修改原型数组的第一个元素
        person1[0] = p4;

        System.out.println("============================================");
        System.out.println(Arrays.toString(person1));
        System.out.println(Arrays.toString(person2));

    }

    /**
     *
     *  克隆(默认浅拷贝)：两个变量指向不同地址
     * 所有的数组都被视为实现接口Cloneable(类只有实现接口Cloneable才可使用Object.clone方法)
     */
    public static void cloneBase() {

        int[] base = {1, 2, 3};
        int[] copy = base.clone();
        copy[0] = 11;
        log.info("Copied arrays" + Arrays.toString(copy) + " and original arrays" +Arrays.toString(base));
        // intArrayCloned变量存放在栈中，该栈的内容为(存放于堆中的)原始数组地址
        // false <-- 深浅拷贝均在堆中新开辟空间，原始对象和拷贝后对象地址一定不相等
        log.info("Cloned arrays address equal(==) ?: " + (copy == base));
        // true
        log.info("Cloned arrays referenced address equal(==) ?: " + (Arrays.equals(copy, base)));
    }
}
