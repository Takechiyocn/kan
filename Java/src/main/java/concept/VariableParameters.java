package concept;

/**
 * @description: 可变参数
 * @author: Kan
 * @date: 2021/2/23 22:38
 */
public class VariableParameters {

    public static void main(String[] args) {
        double[] values = new double[]{2, 3.11, -1.0};
        System.out.println(max(values));
        System.out.println(max(1, 2, 3, 4));
        // Object数组可存储不同数据结构（此处1转换成相应包装类Integer）
        System.out.printf("%d,%s", new Object[]{1, "test"});
    }

    // static defined
    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (v > largest) {
                largest = v;
            }
        }
        return largest;
    }
}
