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
    public static boolean hasNull(GenericTypeCommon<?> p) {
//        GenericTypeCommon pair = p;
//        Object obj = pair;
//        p.setFirst(new File("test"));
//        p.setFirst(pair);
        return p.getFirst() == null || p.getSecond() == null;
    }

    /**
     * 泛型方法也可实现同样效果
     *
     * @param p
     * @param <T>
     * @return
     */
    public static <T> boolean hasNull2(GenericTypeCommon<T> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void main(String[] args) {

        // a.
        GenericTypeCommon<String> pair = new GenericTypeCommon<>("aa", null);
        if (hasNull(pair)) {
            System.out.println("Contain null element");
        } else {
            System.out.println("Not contain null element");
        }

        // a.
        GenericTypeCommon<String> pair2 = new GenericTypeCommon<>(null, null);
        if (hasNull(pair2)) {
            System.out.println("Contain null element");
        } else {
            System.out.println("Not contain null element");
        }

        // c. 可用任意Object对象(Object obj1,obj2...)调用原始类的setObject方法
        GenericTypeCommon<String> stringObject = GenericTypeCommon.minmax(new String[] {"Mary","Lily"});
        // 能赋值和设置(setFirst)原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        //   -> 永远可以将*****参数化类型(如Pair<String>)*****转换为一个原始类型Pair
        GenericTypeCommon rawString = stringObject;
        // 不安全的更改器方法
        rawString.setFirst(new File("test"));
        // 运行时错误：类型转换错误ClassCastException
//        String other = (String)rawString.getFirst();

        Employee[] el = {
                new Employee("e1"),
                new Employee("e2")
        };
        GenericTypeCommon<Employee> employeeObject = GenericTypeCommon.minmax(
//                el
                // 匿名数组
                new Employee[]{new Employee("e1"), new Employee("e2")}
        );
        // 能赋值和设置(setFirst)原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        //   -> 永远可以将*****参数化类型(如Pair<String>)*****转换为一个原始类型Pair
        GenericTypeCommon rawEmployee = employeeObject;
        // 不安全的更改器方法
        rawEmployee.setFirst(new File("test"));
    }
}
