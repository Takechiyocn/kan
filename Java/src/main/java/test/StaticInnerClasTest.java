package test;

import innerclass.StaticInnerClass;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 23:29
 */
public class StaticInnerClasTest {
    public static void main(String[] args) {
        double[] values = new double[20];
        for (int i = 0; i < 20; i++) {
            values[i] = 100 * Math.random();
        }

        StaticInnerClass.Pair p = StaticInnerClass.minmax(values);
        System.out.println("Min:" + p.getFirst() + ", Max:" + p.getSecond());
    }
}
