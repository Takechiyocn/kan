package collection.listbase.arraylist;

import lombok.extern.slf4j.Slf4j;
import occupation.Employee;
import occupation.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 21:54
 */
@Slf4j
public class ArrayListAndArrayConvert {
    public static void main(String[] args) {
        // ArrayList的实现本质上是一个数组
        // ArrayList to array: use ArrayList.toArray(T[] a)
        arrayListToArray();

        // Array to ArrayList: use Arrays.asList
        arrayToArrayList();

        // Array to ArrayList: use new ArrayList<Type>(Arrays.asList)
        arrayToArrayList2();

        // 泛型数组列表扩展
        ArrayList<Employee> employees = new ArrayList<>(){{
            add(new Employee(60000));
            add(new Employee(70000));
        }};
        ArrayList<Manager> managers = new ArrayList<>(){{
            add(new Manager("cfo",11,1990,1,1));
            add(new Manager("ceo",11,1990,1,1));
        }};

        // 泛型实例之间没有关系继承关系
        // 故不复合下转上规则，下列赋值会出错
//        ArrayList<Employee> employees1 = managers;
    }

    private static void arrayToArrayList2() {
        String[] array = new String[3];
        array[0] = "D";
        array[1] = "E";
        array[2] = "F";
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList.add("X");
        for (String s : arrayList) {
            log.info("Array to arrayList use new ArrayList<Type>(Arrays.asList()):" + s);
        }
        arrayList.forEach(x-> log.info("Lambda expression:" + x));
    }

    private static void arrayToArrayList() {
        String[] array = new String[3];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";
        // asList返回的列表是定义在java.util.Arrays中一个私有静态类
        // asList()返回的列表是由原始数组支持的固定大小的列表
        // 如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。
        List<String> arrList = Arrays.asList(array);
//        arrList.add("AA");  // 程序会抛出异常UnsupportedOperationException
        for (String s : arrList) {
            log.info("Array to arrayList use Arrays.asList():" + s);
        }
        // use Lambda expression
        arrList.forEach(x -> log.info("Lambda expression:" + x));
    }

    /**
     *
     */
    public static void arrayListToArray() {
        // 1. array = arrList.toArray(new String[0])
        // 子类对象可声明为父类或者接口类型（从下往上）
        List<String> arrList = new ArrayList<String>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        String[] array = arrList.toArray(new String[0]);
        for (String s : array) {
            log.info("ArrayList to array use ArrayList.toArray(new String[0]):" + s);
        }

        // 2. arrayList.toArray(array)
        ArrayList<String> arrList2 =new ArrayList<>();
        arrList2.add("aa");
        arrList2.add("bb");
        arrList2.add("cc");

        String[] el = new String[arrList2.size()];
        // 1. 不用指定数组长度
        String[] el2 = arrList2.toArray(new String[0]);
        // 2. 需要指定数组长度
        //    返回范类型数组(转换后数组地址已保存在参数中，故该返回值可丢弃)
        arrList2.toArray(el);
        // 非常规测试用
        String[] el3 = new String[arrList2.size()];
        String[] el4 = arrList2.toArray(el3);
        for (String s : el) {
            log.info("ArrayList to array use ArrayList.toArray(array):" + s);
        }
        // false：String类覆写了String方法，但数组(String类型)为引用类型，故使用Object类的equals方法
        log.info("el == el2 ? :" + el.equals(el2));
        // true：数组覆写equals方法
        log.info("el == el2 ? :" + Arrays.equals(el, el2));
        // false
        log.info("el2 == el3 ? :" + el2.equals(el3));
        // true
        log.info("el == el3 ? :" + el3.equals(el4));
    }
}
