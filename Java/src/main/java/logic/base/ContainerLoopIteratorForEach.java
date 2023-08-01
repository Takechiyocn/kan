package logic.base;

import logic.container.iterator.IteratorBase;
import logic.occupation.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 增强for循环(foreach):遍历单值集合或数组
 * 优点：a.简洁
 *      b.效率和for循环相同
 *      c.不用关心下标，减少出错概率
 * 缺点：a.不能同时遍历多个集合
 *      b.遍历时无法修改和删除集合/数组数据
 *
 * @author moku
 */
public class ContainerLoopIteratorForEach {

    /**
     * @description 迭代器遍历集合
     * 默认修饰符(无修饰符no-modifier/package-private,仅包可见)
     * @author moku
     * @return void
     */
    static void iteratorOfCollection() {
        // 传统初始化
        HashSet<Employee> employeeHashSet = new HashSet<>();
        employeeHashSet.add(new Employee("e1"));
        employeeHashSet.add(new Employee("e2"));
        // 匿名初始化
        HashSet<Employee> employeeHashSet2 = new HashSet<>() {{
            add(new Employee("e3"));
            add(new Employee("e4"));
        }};

        // 1. 标准for循环(List集合才有get方法,HashSet实现Set接口)
        Iterator<Employee> iterator = employeeHashSet.iterator();
        for (int i = 0; i < employeeHashSet.size() && iterator.hasNext(); i++) {
            System.out.println("Iterator by Collection:" + iterator.next());
        }

        // 重置迭代器(原迭代器已遍历完容器元素，当前位置为HashSet对象末尾)
        Iterator<Employee> iterator2 = employeeHashSet.iterator();
        iterator = employeeHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("New Iterator by Collection:" + iterator.next());
        }

        // 2. 增强for循环(foreach):遍历单值集合
        // 增强for循环可操作任何实现了Iterable接口的对象
        for (Employee e : employeeHashSet2) {
            System.out.println("Iterator by Collection(for-each):" + e);
        }
    }

    /**
     * @description 迭代器遍历数组
     * @return void
     * @author moku
     */
    public static void iteratorOfArrays() {
        // 静态初始化简写形式
        String[] arrays = {
                "A",
                "B",
                "C"
        };

        /**
         * Stream实现迭代器Iterator，底层实现仍为普通的for循环
         * {@link IteratorBase#listIteratorAccess} ：遍历迭代器剩下元素}
         * {@link IteratorBase#listIteratorAccess(Collection)} ：遍历迭代器剩下元素}
         * @see IteratorBase#listIteratorAccess} ：遍历迭代器剩下元素
         * @see IteratorBase#listIteratorAccess(Collection)} ：遍历迭代器剩下元素
         */
        Iterator<String> iterator = Arrays.stream(arrays).iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator by Array:" + iterator.next());
        }
        // 增强for循环(foreach):遍历数组
        for (String str : arrays) {
            System.out.println("Iterator by Array(for-each->底层为普通for循环):" + str);
        }
    }

    public static void main(String[] args) {
        iteratorOfCollection();
        iteratorOfArrays();
    }
}
