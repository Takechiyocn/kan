package generic.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * 约束与局限性6：不能实例化泛型数组实例，即不能使用new T[](...)来构造泛型对象
 * -> 可以声明域为泛型数组，但不能直接实例化
 * -> minmax中，类型擦除后数组为Comparable，不是本意
 * 解除约束：
 * 1. 实例化泛型数组实例：通过函数式接口
 * 2. 实例化泛型数组实例：通过反射
 *
 * @param <E>
 */
public class Pair2<E, U> {

    /**
     * 声明泛型数组(未实例化)，数组为私有域
     */
    private E[] elements;

    public E getFirst() {
        return elements[0];
    }

    /**
     * 对于该类而言，类型变量已经由泛型类（ArrayList<E>）定义为E
     * 下列定义：
     * public <E> E getSecond() {...}
     * -> 此处新定义的类型变量覆盖泛型类定义的E（即返回类型E），新定义的类型变量以下略称为E2
     * -> return返回时 将进行强制类型转换，即新定义的类型变量E覆盖类定义的类型变量E
     * 由于属于不同的类型变量，故不能转换，编译错误。
     * -> 解决方法：使用不同的类型变量
     * <p>
     * 将导致getSecond方法的类型变量<E>中的E和泛型类定义的类型变量进行强制类型转换
     *
     * @return
     */
    public E getSecond() {
        return elements[1];
    }
    // 使用不同的类型变量，但此处X未使用
    public <X> E getThird() {
        return elements[1];
    }
    // 返回不同类型的类型变量
    public <X> X getForth() {
        return (X)elements[1];
    }

    public Pair2() {
        // 小技巧：用Object掩盖泛型类型，以此实例化泛型数组
        // 此处强制类型转换是一个假象：类型擦除后使其无法察觉，即擦除后没有强制类型转换
        // 类型擦除后：Object[] ?? = Object[] ?? --> OK
        elements = (E[]) new Object[10];
    }

    /**
     * 错误1：擦除后类型跟调用元类型不一致错误
     * 错误2：运行时错误cast error
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] minmax(T... a) {

        // 错误1：擦除后类型跟调用元类型不一致错误
        // 类型擦除后将永远构造Comparable[2]数组
//        T[] nn = new T[2];

        // 错误2：运行时错误cast error
        Object[] mm = new Object[2];

        // 比较处理省略
        mm[0] = a[0];
        mm[1] = a[1];

        // 小技巧：用Object掩盖泛型类型，以此实例化泛型数组
        // 此处强制类型转换是一个假象：类型擦除后使其无法察觉，即擦除后没有强制类型转换
        // 类型擦除后：(T[]) mm 变为 Object[] mm  --> OK
        //     返回时：Object[] mm 内部强制转换为限定类型 Comparable[] ??  （上转下NG） --> NG:cast error
        //  TODO: 编译能通过原因：有强制类型转换(此时T为未知类型)且不涉及到类型擦除？，运行时调用虚拟机才涉及到类型擦除（此时T为Comparable类型）？
        return (T[]) mm;
    }

    /**
     * 1. 实例化泛型数组实例：通过函数式接口
     * TODO：推测1：函数签名类型擦除后为通配类型（函数式接口Function能从给定的值生成指定类型的实例）？：Comparable[] minmax2(IntFunction<?[]>, Object...a)
     *
     * @param constr
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] minmiax2(IntFunction<T[]> constr, T... a) {

        // TODO: 推测2：由于使用函数式接口，类型擦除后下列变量T变为调用元的String类型？，a依旧为Object类型？
        T[] mm = constr.apply(2);

        // 比较处理省略
        // TODO: 推测3：mm为String类型数组，下列赋值其实包含强制类型转换：Object.toString()？
        mm[0] = a[0];
        mm[1] = a[1];

        return mm;
    }

    /**
     * 2. 实例化泛型数组实例：通过反射
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] minmax3(T... a) {

        // 获取原始类型：此处为String
        T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);

        mm[0] = a[0];
        mm[1] = a[1];

        return (T[]) mm;
    }

    public static void main(String[] args) {

        // 错误2：运行时错误cast error
//        String[] ss = minmax("Tom","Dick","Harry");

        // 解除约束：
        //   1. 实例化泛型数组实例：通过函数式接口
        // 构造器表达式(方法引用)：指定参数，构造一个指定长度的String数组
        String[] tt = Pair2.minmiax2(String[]::new, "Tom", "Dick", "Harry");
        System.out.println(Arrays.toString(tt));
        // TODO：推测4：下列能赋值的原因：
        //              a: minmiax2返回String[]，String实现了Comparable接口，下转上  -> 可能性大
        //              b: minmiax2返回Comparable接口类型 -> 可能性小
        Comparable[] uu = Pair2.minmiax2(String[]::new, "Tom", "Dick", "Harry");
        System.out.println(Arrays.toString(uu));

        // 解除约束：
        //   2. 实例化泛型数组实例：通过反射
        String[] vv = Pair2.minmax3("Tom", "Dick", "Harry");
        System.out.println(Arrays.toString(vv));
    }
}
