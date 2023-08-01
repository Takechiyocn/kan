package logic.varargs;

/**
 * 可变实参
 * 结论：和“用数组包裹(T[] args)”的做法相比，真正的实参个数可变的方法，
 * 在调用时传递参数的操作更为简单，含义也更为清楚。
 * 不过，这一机制也有它自身的局限，并不是一个完美无缺的解决方案
 *
 * @author moku
 */
public class PrintfSample {
    public static void main(String[] args) {

        // 处理收到的可变实参
        System.out.println(sumUp(10, 20, 30));

        // 转发收到的可变实参
        // 打印出“Pi:3.141593 E:2.718282”
        printOut("Pi:%f E:%f\n", Math.PI, Math.E);

        // 可变实参与泛型（泛型类型与返回类型一致）
        System.out.println(getMiddle(10, 30, 40));
        // 可变实参与泛型（泛型类型与返回类型不一致）
        voidReturnType(10, 30, 40);

        // 可变实参与重载
        // 实参个数固定的版本优先于实参个数可变的版本
        // "A"
        testOverloading(1);
        // "B"
        testOverloading(1, 2);
        // "C"
        testOverloading(1, 2, 3);

        // 可变实参与重载2: 引用歧义
//        testOverloadingAmbiguous(1, 2, 3);

        // 可变实参与重载3: 装箱拆箱引发引用歧义
//        testOverloadingBoxing(2.0, 3.0);

    }

    /**
     * 处理收到的实参
     *
     * @param values
     * @return
     */
    private static int sumUp(int... values) {
        int sum = 0;
        for (int n : values) {
            sum += n;
        }

        return sum;
    }

    /**
     * 转发收到的实参
     *
     * @param format
     * @param args
     */
    private static void printOut(String format, Object... args) {
        // J2SE 1.5里PrintStream新增的printf(String format, Object... args)方法
        // 按一定格式输出字符串:PrintStream的printf方法
        System.out.printf(format, args);
        // 按一定格式组合字符串:String.format
        String ps = String.format(format, args);
        System.out.print(ps);
    }

    /**
     * 自定义泛型方法
     * 尖括号内T：范型的类型变量
     * 调用泛型方法时，方法名前的尖括号中放入具体类型
     * 如：GenericTypeCommon.<String>getMiddle("john","abc");
     * 如：GenericTypeCommon.<double>getMiddle(3.14,172,0);
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a) {
        // TODO:反射Integer类型时，显示不完整 [Ljava.lang.Integer;
        System.out.println("泛型类型变量与返回类型一致，返回类型：" + a.getClass());
        return a[a.length / 2];
    }

    /**
     * 泛型类型变量与返回值类型不一致
     * J2SE1.5泛型机制约束：不能拿用标识符<T></>来代表的类型来创建这一类型的实例
     * J2SE1.8之前该函数会报generic array creation错误
     * TODO：可变参数与堆污染
     *
     * @param args
     * @param <T>
     */
    public static <T> void voidReturnType(T... args) {
        System.out.println("泛型类型变量与返回类型不一致，返回类型：void");
    }

    /**
     * 原函数
     *
     * @param i
     */
    private static void testOverloading(int i) {
        System.out.println("A");
    }

    /**
     * 重载1
     *
     * @param i
     * @param j
     */
    private static void testOverloading(int i, int j) {
        System.out.println("B");
    }

    /**
     * 重载2
     *
     * @param i
     * @param more
     */
    private static void testOverloading(int i, int... more) {
        System.out.println("C");
    }

    /**
     * 重载引发歧义
     *
     * @param args
     */
    private static void testOverloadingAmbiguous(Object... args) {
        System.out.println("AA");
    }

    /**
     * 重载引发歧义
     *
     * @param o
     * @param args
     */
    private static void testOverloadingAmbiguous(Object o, Object... args) {
        System.out.println("BB");
    }

    /**
     * 装箱拆箱引发歧义
     *
     * @param args
     */
    private static void testOverloadingBoxing(double... args) {
        System.out.println("AAA");
    }

    /**
     * 装箱拆箱引发歧义
     *
     * @param args
     */
    private static void testOverloadingBoxing(Double... args) {
        System.out.println("BBB");
    }
}
