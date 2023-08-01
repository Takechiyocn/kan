package logic.clone;

import java.util.Arrays;

/**
 * @description: 所有的数组类型都有public的clone方法(Arrays实现了Object的clone方法)
 *               克隆后两个数组指向不同引用
 * @author: Kan
 * @date: 2021/2/28 1:59
 */
public class ArraysClone {
    public static void main(String[] args) {
        Integer[] luckNumbers = {2, 3, 5, 7, 11};
        Integer[] cloned = luckNumbers.clone();
        Integer[] cloned2 = luckNumbers.clone();
        cloned[1] = 99;
        System.out.println(Arrays.toString(luckNumbers));
        System.out.println(Arrays.toString(cloned));
        // Arrays.equal:比较两个数组包含的元素是否相等
        // false
        System.out.println(Arrays.equals(luckNumbers, cloned));
        // true
        System.out.println(Arrays.equals(luckNumbers, cloned2));
        // 比较两个数组所指向的引用（地址）直接用==
        // false
        System.out.println(cloned2 == luckNumbers);

    }
}
