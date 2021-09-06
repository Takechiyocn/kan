package innerclass;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 23:29
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {

        double[] values = new double[20];
        for (int i = 0; i < 20; i++) {
            values[i] = 100 * Math.random();
        }

        StaticInnerClass.Pair p = StaticInnerClass.minmax(values);
        System.out.println("Min:" + StaticInnerClass.Pair.getFirst() + ", Max:" + p.getSecond());
    }
}
