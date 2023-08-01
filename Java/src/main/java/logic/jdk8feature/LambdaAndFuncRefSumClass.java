package logic.jdk8feature;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * @description: 函数式接口functional interface
 *               定义：对于只有一个抽象方法的接口，需要这种接口的对象时，
 *                    可以提供一个lambda表达式，这种接口称为函数式接口，可以用@FunctionalInterface修饰一下
 *               特点：1. Lambda并不是任何地方都可以使用，Lambda表达式需要“函数式接口”的支持。
 *                    2. 未使用 @FunctionalInterface注解的接口未必就不是函数式接口，
 *                    3. 一个接口是不是函数式接口的条件只有一条，即接口中只有一个抽象方法的接口（Object类中的方法不算）。
 *                       而使用@FunctionalInterface注解修饰了的接口就一定是函数式接口，添加@FunctionalInterface注解可以帮助我们检查是否是函数式接口。
 * @author: Kan
 * @date: 2021/2/28 22:57
 */
@Slf4j
public class LambdaAndFuncRefSumClass {

    public static void main(String[] args) {

        String[] planets = new String[]{"Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        log.info("Before:" + Arrays.toString(planets));

        // Array(数组)的全部变量(此处为String类型变量)必须实现Comparable接口(覆盖函数：compareTo)
        Arrays.sort(planets);
        log.info("Order by alphabet:" + Arrays.toString(planets));

        // public static <T> void sort(T[] a, Comparator<? super T> c) {}
        //   c: 对象比较器
        // 当接口只有一个抽象方法时，可以使用Lambda表达式实现Comparator接口(覆盖函数：compare)
        //   -> Comparator的boolean equals(Object obj);方法来自Object，这种对Object类的方法的重新声明会让方法不再是抽象的。
        //      Java API中的一些接口会重新声明Object方法来附加javadoc注释
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        log.info("Order by length:" + Arrays.toString(planets));

        // 1.静态方法引用：class: staticMethod
        BiFunction<Double, Double, Double> biFunction = Math::pow;
        log.info("Math pow 2 of 3 is " + biFunction.apply(2.0, 3.0));

        // 使用ActionListener的函数式接口(actionPerformed被lambda表达式或方法引用实现覆盖)
//        Timer t = new Timer(5000, e -> log.info("The time is " + new Date()));
        // println:方法引用(method reference)  <--> System.out.println(x)
//        Timer t = new Timer(10000, e -> System.out.println(e));

        // 2.实例方法引用::object:instanceMethod
        Timer t = new Timer(5000, System.out::println);
        t.start();

        JOptionPane.showConfirmDialog(null, "Quit program?");

        // this::equals   <--> x -> this.equals(x)
        // super::instanceMethod

        // 3.对象方法引用:class:instanceMethod
        //   第一个参数称为方法的目标，如下列等于 (x,y) -> x.compareToIgnoreCase(y)
        Arrays.sort(planets, String::compareToIgnoreCase);
        log.info("Order by alphabet use method reference(lambda):" + Arrays.toString(planets));

        System.exit(0);
    }
}
