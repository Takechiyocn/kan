package logic.generic;

import logic.errohandler.exception.ExceptionWithGeneric;
import logic.generic.constraint.*;

/**
 * 约束与局限性：
 * 1. 不能用基本类型实例化类型参数type parameter
 *     类型参数：<T, U>，<T extends Comparable>,即<>整体为类型参数
 *     类型变量：<T, U>，<T extends Comparable>中的T、U，放在访问修饰符后，返回类型之前
 *      -> GenericTypeCommon<T, U>表示GenericTypeCommon类的第一个和第二个域分别使用不同的类型
 * 2. 运行时类型检查只适用于原始类型
 * 3. 不能创建参数化类型(此处String/Integer等)的数组，即不支持泛型类型的数组
 *     -> 参数化类型理解：即类型(参数)被参数化
 *        var gt = new GenericTypeCommon<String>[10]; // Error
 * 4. 泛型与可变参数，消除泛型数组限制(上述3)，有风险
 *     -> 泛型数组：不安全，包括以下方式消除泛型数组限制
 *         a. 声明通配类型数组，然后进行强制类型转换
 *         b. 通过可变参数与泛型结合
 *     -> 泛型数组列表：安全
 * 5. 泛型类中，不能实例化泛型<T>实例/不能实例化类型变量，即不能用new T(...)
 * 6. 泛型类中，不能实例化泛型数组实例，即不能使用new T[](...)来构造泛型对象
 *     -> 可实例化泛型类型的数组，即泛型类型确定化，与新建对象如new Employee类似。
 *        --> 消除泛型数组限制(上述6)
 *            a. 实例化泛型数组实例：通过函数式接口
 *            b. 实例化泛型数组实例：通过反射
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
 *               {@link GenericTypeCommon#equals2(Object)}}
 *
 * @author: Kan
 * @date:
 */
public class GenericTypeConstraint {

    public static void main(String[] args) {

        // 约束与局限性1
        GenericTypeConstraint1.confirm();

        // 约束与局限性2
        GenericTypeConstraint2.confirm();

        // 约束与局限性3
        GenericTypeConstraint3.confirm();

        // 约束与局限性4
        GenericTypeConstraint4.confirm();

        // 约束与局限性5
        GenericTypeConstraint5.confirm();

        /**
         * 约束与局限性6：不能实例化泛型数组实例，即不能使用new T[](...)来构造泛型对象
         * {@link GenericTypeConstraint6}
         */
        // 约束与局限性6
        GenericTypeConstraint6.confirm();


        // 约束与局限性7：泛型类中的类型变量在静态上下文中无效，即不能在静态变量或者静态方法中引用类型变量（静态方法中的参数可以为类型变量）
        //  -> 原因：类型擦除后类运行时为同一个类，而静态变量又称为类变量，即一个类所有的对象共享静态变量。
        //          类型变量(此处为域变量T xxx)由不同类型实例化后，具体指向不清楚。如Person和Student类型实例化后，instance指向不明
        // 参见下列内部类：class Singleton
//        class Singleton<T> {
//            // 报错
//            private static T instance;
//            // 报错
//            public static T getInstance(){
//                if(instance != null) {
//                    return instance;
//                } else {
//                    return null;
//                }
//            }
//        }

        // 约束与局限性8：不能抛出或捕获泛型类的实例，泛型类也不能扩展Throwable

        /**
         * 约束与局限性9：消除对受查异常的检查，即让编译器认为是一个非受查异常
         * {@link ExceptionWithGeneric}
         */

        /**
         * 约束与局限性10：注意擦除后的冲突
         *  冲突1：方法擦除后冲突
         *    -> {@link GenericTypeCommon#equals2(Object)}}
         *  冲突2：要向支持擦除的转换，就需要强行限制一个类或类型变量不能同时成为两个接口类型的子类型，
         *        而这两个接口是同一接口的不同参数化
         *        -> 原因： 实现了Comparable<X>合成的桥方法： public int compareTo(Object other) { return compareTo((X) other);}
         *                  不同类型的X不能有两个相同的桥方法
         */
        abstract class Employee1 implements Comparable<Employee1> {
        }
        // 冲突2：
//        absclazz class Manager extends Employee1 implements Comparable<Manager> {
//        }
    }
}
