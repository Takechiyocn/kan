package logic.container.collection.listbase.arraylist;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Arrays.asList参数应为引用类型或基本类型包装类类型的数组
 * 2. Arrays.asList返回的列表是定义在java.util.Arrays中一个私有静态类
 * Arrays.asList()返回的列表是由原始数组支持的固定大小的列表
 * 如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。
 *
 * @author moku
 */
@Slf4j
public class ArraysAsList {
    public static void main(String[] args) {

        // Array to ArrayList: use Arrays.asList
        arrayToArrayList();

//        arrayToArrayList2();
    }

    private static void arrayToArrayList() {
        // 静态初始化
        String[] array = new String[]{"A", "B", "C"};
        // 静态初始化简写(匿名)
        String[] array2 = {"A", "B", "C"};

        int[] data = {1, 2, 3, 4, 5};
        // Arrays.asList参数原型为泛型变长参数，基本类型不能作为泛型的参数，应使用基本类型对应的包装类型
        // 此处数组泛型化，转换后list列表里有一个类型为int的数组元素
        List intList = Arrays.asList(data);

        // Arrays.asList()返回的列表是由原始数组支持的固定大小的列表
        // 抛出异常UnsupportedOperationException
//        intList.add(6);
        // 输出:1
        System.out.println(intList.size());
        // 输出数组列表第一个元素的类型(此处为数组)，JVM无法输出数组(array)类型，只可通过java.lang.reflect访问数组类
        // 输出:class [I
        System.out.println(intList.get(0).getClass());
        // 获取数组第一个元素：List中第一个元素(数组)的第一个元素
        System.out.println("基本类型数组使用asList时，返回List的第一个元素为基本类型数组：" + ((int[])intList.get(0))[0]);

        Integer[] wrapperInt = {1, 2, 3, 4, 5};
        List integerList = Arrays.asList(wrapperInt);
        // 输出:5
        System.out.println(integerList.size());
        // Arrays.asList()返回的列表是由原始数组支持的固定大小的列表
        // 抛出异常UnsupportedOperationException
//        integerList.add(6);
        // 输出数组列表第一个元素的类型
        // 输出:class java.lang.Integer
        System.out.println(integerList.get(0).getClass());
    }

    /**
     * 枚举
     */
    enum Week {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat;
        // TODO: 枚举类 增加 成员方法
        void add() {

        }
    };

    private static void arrayToArrayList2() {
        Week[] workDays = {Week.Mon, Week.Tue, Week.Wed, Week.Thu, Week.Fri};
        List<Week> list = Arrays.asList(workDays);
        list.add(Week.Sat);
    }
}
