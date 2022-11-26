package generic;

import occupation.Employee;
import occupation.Manager;

import static generic.Wildcard2.minmaxBonus;

/**
 * 捕获通配符
 * 约束：编译器必须能够确信通配符表达的是单个、确定的类型
 *   -> ArrayList<GenericTypeCommon<T>中的T则不能捕获ArrayList<GenericTypeCommon<?>中的通配符，
 *      因为数组列表可以保存多个Pair<?>，分别针对不同的类型
 */
public class Wildcard4 {

    /**
     * 交换成对元素
     * @param p：参数类型： GenericTypeCommon<?></>
     */
    public static void swap(GenericTypeCommon<?> p) {
        // 进行捕获2次？捕获传递？
        swapHelper(p);
    }

    /**
     * 泛型方法
     *   类型参数T捕获通配符，它不知道是哪种类型的通配符，但这是一个明确的类型(T)
     *   <T> swapHelper的定义只有在T指出类型时才有明确含义，即运行时调用该方法时。
     *
     * @param p
     * @param <T>
     */
    public static <T> void swapHelper(GenericTypeCommon<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

    /**
     * 比较bonus大小并交换元素
     * @param a
     * @param result
     */
    public static void maxminBonus(Manager[] a, GenericTypeCommon<? super Manager> result) {
        // 设置最大最小bonus元素
        //   编译时不知道result内的?是哪种类型的通配符，所以必须要进行捕获
        minmaxBonus(a, result);
        // 交换最大最小bonus元素
        // 进行捕获1次？
        swap(result);
    }

    public static void main(String[] args) {

        Manager[] mm = {
                new Manager("m1", 1000, 11, 11, 11),
                new Manager("m2", 1000, 11, 11, 11)
        };
        mm[0].setBonus(1000);
        mm[1].setBonus(2000);
        Employee e1 = new Employee("employee1");
        Employee e2 = new Employee("employee2");
        GenericTypeCommon<Employee> employeePair = new GenericTypeCommon<>();
        System.out.println("交换前：First["+ employeePair.getFirst() + "], Second[" + employeePair.getSecond() + "]");
        // 交换元素：使之-> 最大->first， 最小->second
        maxminBonus(mm, employeePair);
        System.out.println("交换后：First["+ employeePair.getFirst() + "], Second[" + employeePair.getSecond() + "]");
    }
}
