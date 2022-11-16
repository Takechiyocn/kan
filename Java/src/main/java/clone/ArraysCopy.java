package clone;

import java.util.Arrays;

/**
 *
 * 复制数组
 *   1. Arrays.copyOf
 *     -> 小数组复制效率高
 *   2. Arrays.copyOfRange
 *     -> 效率中庸
 *   3. System.arraycopy：本地方法
 *     -> 中/大数组复制效率高
 *   4. Object.clone: 需实现Cloneable接口(数组默认实现该接口)
 *     -> 中等数组复制效率高
 *   5. for循环
 *      -> 小数组复制效率高
 * @Author moku
 * @Date 2022/11/16 21:36
 * @Version 1.0
 */
public class ArraysCopy {

    /**
     * 复制数组(指定长度)
     */
    public static void arraysCopyOf() {
        int[] original = {1, 3, 5, 7, 9};
        // 目标数组不存在
        // [1, 3, 5, 7, 9, 0, 0, 0]
        int[] copy = Arrays.copyOf(original, 8);

        // 目标数组存在：目标数组被重构(清空并复制)
        int[] newArray = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
        // [1, 3, 5, 7, 9, 0]
        newArray = Arrays.copyOf(original, 6);

        // 增强for循环：遍历单值集合或数组
        for (int m : copy) {
            System.out.print(m + "\t");
        }
        System.out.println("\n" + Arrays.toString(copy));
    }

    /**
     * 复制数组(范围)
     */
    public static void arraysCopyOfRange() {
        int[] original = {1, 3, 5, 7, 9, 11, 13, 15};
        // 目标数组如果已经存在，将会被重构
        int[] copy = Arrays.copyOfRange(original, 0, 5);
        System.out.println(Arrays.toString(copy));
    }

    /**
     * 数组复制：本地方法(中大型数组复制效率高)
     * 目标数组必须已经存在，且不会被重构即替换目标数组相应元素
     */
    public static void systemArrayCopy() {
        int[] original = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] copy = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
        System.arraycopy(original,0, copy, 2, 8);
        System.out.println(Arrays.toString(copy));
    }

    public static void main(String[] args) {
        arraysCopyOf();
        arraysCopyOfRange();
        systemArrayCopy();
    }
}
