package innerclass;

/**
 * @description: 静态内部类（嵌套类nested class）：不需要内部类引用外围类对象，将内部类声明为static，以便取消产生的引用
 *  静态嵌套类：什么是嵌套？嵌套就是我跟你没关系，自己可以完全独立存在，但是我就想借你的壳用一下，来隐藏一下我自己
 *   特点：
 *     静态内部类可以有静态域和方法
 *     声明在接口中的内部类自动成为static和public类
 *     静态内部类的作用：只是为了降低包的深度，方便类的使用，静态内部类适用于包含类当中，但又不依赖与外在的类，
 *       不用使用外在类的非静态属性和方法，只是为了方便管理类结构而定义。在创建静态内部类的时候，不需要外部类对象的引用。
 *
 *  TODO：静态类？
 *
 * @author: Kan
 *
 */
public class StaticInnerClass {
    /**
     * 静态内部类
     */
    public static class Pair {
        // 域声明为静态
        private static double first;
        // 域声明为非静态
        private double second;

        public Pair(double first, double second) {
            // 通过类实例访问静态成员：不推荐
//            this.first = first;
            Pair.first = first;
            this.second = second;
        }

        // 方法声明为静态
        public static double getFirst() {
            return first;
        }

        // 方法声明为非静态
        public double getSecond() {
            return second;
        }
    }

    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double v: values) {
            if (min > v) {
                min = v;
            }

            if (max < v) {
                max = v;
            }
        }

        return new Pair(min, max);
    }
}
