package generic;

import occupation.Employee;

import java.io.File;

/**
 * 无限定通配符
 */
public class Wildcard3 {

    /**
     * 特点：
     * a. getFirst返回值只能赋值给Object
     * b. setFirst不能被调用，Object调用也不行
     * c. 无限定通配符Pair<?>和原始类型Pair区别：可用任意Object对象(Object obj1,obj2...)调用原始类的setObject方法
     * 用途：对某些进行简单操作有用，如测试pair是否包含null引用
     */
    public static boolean hasNull(Pair<?> p) {
//        Pair pair = p;
//        Object obj = pair;
//        p.setFirst(new File("test"));
        return p.getFirst() == null || p.getSecond() == null;
    }

    /**
     * 泛型方法也可实现同样效果
     *
     * @param p
     * @param <T>
     * @return
     */
    public static <T> boolean hasNull2(Pair<T> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void main(String[] args) {

        // a.
        Pair<String> pair = new Pair<>("aa", null);
        if (hasNull(pair)) {
            System.out.println("Has null element");
        } else {
            System.out.println("Hasn't null element");
        }

        // a.
        Pair<String> pair2 = new Pair<>("aa", null);
        if (hasNull(pair2)) {
            System.out.println("Has null element");
        } else {
            System.out.println("Hasn't null element");
        }

        // c. 可用任意Object对象(Object obj1,obj2...)调用原始类的setObject方法
        Pair<String> stringObject = Pair.minmax(new String[] {"Mary","Lily"});
        // 能赋值和设置(setFirst)原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        //   -> 永远可以将*****参数化类型(如Pair<String>)*****转换为一个原始类型Pair
        Pair rawString = stringObject;
        // 不安全的更改器方法
        rawString.setFirst(new File("test"));

        Employee[] el = {
                new Employee("e1"),
                new Employee("e2")
        };
        Pair<Employee> employeeObject = Pair.minmax(
                el
                // TODO：为什么匿名数组在此不能直接使用？
//                {
//                        new Employee("e1"),
//                        new Employee("e2")
//                }
        );
        // 能赋值和设置(setFirst)原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        //   -> 永远可以将*****参数化类型(如Pair<String>)*****转换为一个原始类型Pair
        Pair rawEmployee = employeeObject;
        // 不安全的更改器方法
        rawEmployee.setFirst(new File("test"));
    }
}
