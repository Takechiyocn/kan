package jdk8feature.methodref;

import java.util.function.IntConsumer;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/1 16:59
 */
public class RepeatLambada {

    public static void main(String[] args) {
        repeatRunnable(2, ()->System.out.println("Runnable无参数无返回值"));

        repeatRunnable(2, System.out::println);
        repeatIntConsumer(2, i -> System.out.println("基本类型函数式接口:" + i));
        repeatIntConsumer(2, System.out::println);
    }

    /**
     * 函数式接口Runnable
     * @param n
     * @param action
     */
    public static void repeatRunnable(int n, Runnable action) {
        for (int i = 0; i<n; i++) {
            action.run();
        }
    }

    /**
     * 基本类型函数式接口：整形的消费型函数式接口
     * @param n
     * @param action
     */
    public static void repeatIntConsumer(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
