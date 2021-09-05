package generic.test;

import exception.ExceptionWithGeneric;
import generic.Pair;
import occupation.Employee;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * 约束与局限性：
 * 1. 不能用基本类型实例化类型参数type parameter
 *     类型参数：<T, U>，<T extends Comparable>,即<>整体为类型参数
 *     类型变量：<T, U>，<T extends Comparable>中的T、U，放在访问修饰符后，返回类型之前
 *      -> TODO：Pair<T, U>表示Pair类的第一个和第二个域分别使用不同的类型
 * 2. 运行时类型检查只适用于原始类型
 * 3. 不能创建参数化类型(此处String)的数组，即不支持泛型类型的数组
 *     -> 参数化类型理解：即类型(参数)被参数化
 *        var table = new Pair<String>[10]; // Error
 * 4. 泛型与可变参数，消除泛型数组限制(上述3)，有风险。
 *      -> 泛型数组：不安全，包括以下方式消除泛型数组限制
 *          a. 声明通配类型数组，然后进行强制类型转换
 *          b. 通过可变参数与泛型结合
 *      -> 泛型数组列表：安全
 * 5. 不能实例化类型变量/不能实例化泛型<T>实例，即不能用new T(...)
 * 6. 不能实例化泛型<T>数组
 *      -> 可实例化泛型类型的数组，即泛型类型确定化，与新建对象如new Employee类似。
 *          --> 消除泛型数组限制(上述6)
 *              a. 实例化泛型数组实例：通过函数式接口
 *              b. 实例化泛型数组实例：通过反射
 * 7. 泛型类中的类型变量在静态上下文中无效，即不能在静态变量或者静态方法中引用类型变量（静态方法中的参数可以为类型变量）
 * 8. 不能抛出或捕获泛型类的实例，泛型类也不能扩展Throwable
 *      a. 扩展
 *          -> Person<T> extends Throwable; // Error
 *             Person<T> extends Exception; // Error
 *      b. catch子句中不能使用类型变量
 *          -> try {...} catch (T e) {} // Error
 * 约束与局限性9：消除对受查异常的检查，即让编译器认为是一个非受查异常
 *              {@link ExceptionWithGeneric}
 * 约束与局限性10：注意擦除后的冲突
 *               {@link generic.Pair#equals2(Object)}}
 *
 * @description:
 * @author: Kan
 * @date:
 */
public class PairTest3 {

    public static void main(String[] args) {

        // 约束与局限性：
        //   1. 不能用基本类型实例化类型参数(泛型类型变量)，即泛型类型变量不能为基本类型
        //      -> 类型擦除后，Object类型的域不能存储基本类型的值
        // 调用时包含参数1:3.14、参数3:(double)0的Double装箱过程
        // 返回时包含Double的拆箱过程
        double gDouble = Pair.<Double>getMiddle(3.14, Double.valueOf(172), (double) 0);
        // 调用时包含Integer装箱过程
        // 返回时包含Integer的拆箱过程
        int gInt = Pair.<Integer>getMiddle(10, 15, 31);
        System.out.println("约束与局限性1：不能用基本类型实例化类型参数[" + gDouble + "]");
        System.out.println("约束与局限性1：不能用基本类型实例化类型参数[" + gInt + "]");

        // 约束与局限性：
        //   2. 运行时类型检查只是用于原始类型
        //     -> 类型查询只产生原始类型
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        // mm类型：Pair
        Pair<String> mm = Pair.minmax(words);
        // true
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (mm instanceof Pair) + "]");
        // Error
//        System.out.println(mm instanceof Pair<String>);
        // Error
//        System.out.println(mm instanceof Pair<T>);
        // class generic.Pair
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (mm.getClass()) + "]");
        Pair<String>[] tmp = (Pair<String>[]) new Pair<?>[10];
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (tmp.getClass()) + "]");
        // equal
        // new Pair<Employee>();中的类型变量可省略，由编译器推导
//        Pair<Employee> employeePair = new Pair<Employee>();
        Pair<Employee> employeePair = new Pair<>();
        // true
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (mm.getClass() == employeePair.getClass()) + "]");

        // 约束与局限性：
        //   3. 不能创建参数化(此处String)类型的数组，即不支持参数化类型的数组
        //    -> 编译错误：generic array creation
//        Pair<String>[] nn = new Pair<String>[10];
        //      规避方法：
        //        a. 声明通配类型数组，然后进行强制类型转换
        //          -> 结果不安全
        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
        Object[] objArray = table;
        table[0] = new Pair<String>("1", "2");
        table[1] = new Pair<String>("3", "4");
        // 能赋值原因：数组存储只会检查擦除后的类型，Pair<String>[] 擦除类型后为Pair[]，可转换为Object[]
        objArray[0] = new Pair<Employee>();
        // 隐藏危险：
        // 预期：1 实际：null（objArray[0] 初始化为空）
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过通配类型数组规避（含隐藏危险）[" + (table[0].getFirst()) + "]");
        // 预期：3 实际：3
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过通配类型数组规避（含隐藏危险）[" + (table[1].getFirst()) + "]");

        //   4. 泛型与可变参数
        //      规避方法：
        //        b. 通过可变参数与泛型结合
        //          -> 结果不安全
        Pair<String> pair1 = new Pair<String>("a", "b");
        Pair<String> pair2 = new Pair<String>("c", "d");
        // 虚拟机尽管产生了参数化类型的数组，但虚拟机对此规则有所放松
        Pair<String>[] table2 = array(pair1, pair2);
        // 能赋值原因：数组存储只会检查擦除的类型，Pair<String>[] 擦除类型后为Pair[]，可转换为Object[]
        Object[] objArray2 = table2;
        objArray2[0] = new Pair<Employee>();
        // 隐藏危险：
        // 预期：a 实际：null（objArray2[0] 初始化为空）
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过可变参数数组规避（含隐藏危险）[" + (table2[0].getFirst()) + "]");
        // 预期：c 实际：c
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过可变参数数组规避（含隐藏危险）[" + (table2[1].getFirst()) + "]");

        //   4. 泛型与可变参数
        //      规避方法：
        //        c. 参数化类型对象数组列表(容器或者其他):ArrayList<Pair<String>>
        //          -> 结果安全
        Collection<Pair<String>> table3 = new ArrayList<Pair<String>>();
        Pair<Employee> pair3 = new Pair<Employee>();
        // 类型不匹配
//        table3.add(pair3);
        // 泛型与可变参数结合使用时：虚拟机将建立一个Pair<String>[]数组，与【 约束与局限性：3】冲突，
        // 但这种情况虚拟机规则有所放松，只产生警告（unchecked generic array creation），
        // 通过@SafeVarargs消除警告
        addAll(table3, pair1, pair2);
        // 不适用可变参数，可直接赋值
        Pair<String> pair4 = new Pair<String>("e", "f");
        table3.add(pair4);
        // Collection容器元素打印
        for (Pair<String> p : table3) {
            System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过数组列表规避（安全）[" + p.getFirst() + "]");
        }

        // 约束与局限性5：不能实例化泛型实例，即不能使用new T(...)来构造泛型对象
        // 可通过下列方法使用类型变量构造对象
        //  a. 通过供给型接口
        //     方法引用构造器：生成空字符串
        Pair<String> p = makePair(String::new);
        // 构造其中如下定义会出错：T类型擦除为Object
//        first = new T();
        // 空字符串
        if (StringUtils.isBlank(p.getFirst())) {
            System.out.println("约束与局限性5：能实例化泛型实例，通过供给型接口实例化类型变量[blank]");
        } else {
            System.out.println("约束与局限性5：能实例化泛型实例，通过供给型接口实例化类型变量[not blank]");
        }

        //  b. 通过反射
        //   String.class是泛型类Class的Class<String>的实例，且为唯一的实例
        Pair<String> p2 = makePair(String.class);
        // 构造其中如下定义会出错：T.class类型擦除为Object.class
//        first = T.class.newInstance();
        // 空字符串
        if (StringUtils.isBlank(p2.getFirst())) {
            System.out.println("约束与局限性5：能实例化泛型实例，通过反射实例化类型变量[blank]");
        } else {
            System.out.println("约束与局限性5：能实例化泛型实例，通过反射实例化类型变量[not blank]");
        }

        /**
         * 约束与局限性6：不能实例化泛型数组实例，即不能使用new T[](...)来构造泛型对象
         * {@link Pair2}
         */

        // 约束与局限性7：泛型类中的类型变量在静态上下文中无效，即不能在静态变量或者静态方法中引用类型变量（静态方法中的参数可以为类型变量）
        //  -> 原因：类型擦除后为运行时为同一个类，而静态变量又称为类变量，即一个类所有的对象共享静态变量。
        //          类型变量(此处为域变量T xxx)由不同类型实例化后，具体指向不清楚。如Person和Student类型实例化后，instance指向不明
        // 参见下列内部类：class Singleton

        // 约束与局限性8：不能抛出或捕获泛型类的实例，泛型类也不能扩展Throwable

        /**
         * 约束与局限性9：消除对受查异常的检查，即让编译器认为是一个非受查异常
         * {@link ExceptionWithGeneric}
         */

        /**
         * 约束与局限性10：注意擦除后的冲突
         *  冲突1：方法擦除后冲突
         *    -> {@link generic.Pair#equals2(Object)}}
         *  冲突2：要向支持擦除的转换，就需要强行限制一个类或类型变量不能同时成为两个接口类型的子类型，
         *        而这两个接口是同一接口的不同参数化
         *        -> 原因： 实现了Comparable<X>合成的桥方法： public int compareTo(Object other) { return compareTo((X) other);}
         *                  不同类型的X不能有两个相同的桥方法
         */
        abstract class Employee1 implements Comparable<Employee1> {
        }
        // 冲突2：
//        abstract class Manager extends Employee1 implements Comparable<Manager> {
//        }
    }


    /**
     * 用@SafeVarargs标注来消除创建泛型数组的有关限制(约束与局限性：3)
     * 虚拟机建立一个Pair<String>[]数组
     *
     * @param array
     * @param <E>
     * @return
     */
    @SafeVarargs
    public static <E> E[] array(E... array) {
        return array;
    }

    /**
     * 虚拟机建立一个Pair<String>[]数组
     *
     * @param coll
     * @param ts
     * @param <T>
     */
    //    @SuppressWarnings("unchecked")
    @SafeVarargs
    static <T> void addAll(Collection<T> coll, T... ts) {
        for (T t : ts) {
            coll.add(t);
        }
    }

    /**
     * 供给型接口Supplier：无参且返回指定类型变量（此处为泛型T）
     * 第一个<T>：表示该函数为一个泛型方法/泛型函数
     * Pair<T> ：表示返回一个泛型类型的变量，即实例化Pair类型变量
     * 泛型类型变量与返回值类型不同
     *
     * @param constr
     * @param <T>
     * @return
     */
    public static <T> Pair<T> makePair(Supplier<T> constr) {
        // 类型变量T可省略，由编译器推导
//        return new Pair<T>(constr.get(), constr.get());
        return new Pair<>(constr.get(), constr.get());
    }

    /**
     * 通过反射构造泛型对象
     *
     * @param cl
     * @param <T>
     * @return
     */
    public static <T> Pair<T> makePair(Class<T> cl) {
        try {
            return new Pair<>(cl.newInstance(), cl.newInstance());
        } catch (Exception ex) {
            return null;
        }
    }

    /*
    //
    class Singleton<T> {
        // 报错
        private static T instance;
        // 报错
        public static T getInstance(){
            if(instance != null)
                return instance;
        }
    }
    */
}
