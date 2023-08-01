package logic.test;

import java.util.function.IntConsumer;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/2 23:16
 */
public class RepeatIntConsumerTest {
    public static void main(String[] args) {
        repeat(10, i -> System.out.println("Countdown:" + (9-i)));
    }

    /**
     * 基本类型函数式接口
     * @param n
     * @param action
     */
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
