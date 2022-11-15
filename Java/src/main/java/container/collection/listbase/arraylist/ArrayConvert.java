package container.collection.listbase.arraylist;

import java.util.Arrays;
import java.util.Collections;

/**
 * 数组反转
 * <p>
 * length属性：数组长度
 * length()方法：字符串长度
 * size()方法：泛型/集合元素个数
 *
 * @author moku
 */
public class ArrayConvert {
    public void arrayListConvert(int[] arr) {
        int temp;

        // 1. 两边逼近
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        // 2.
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        // 3. Collections.reverse方法
        Collections.reverse(Arrays.asList(arr));
    }

    public static void main(String[] args)
    {
        Integer [] arr = {10, 20, 30, 40, 50};
        Collections.reverse(Arrays.asList(arr));
        //
        System.out.println(Arrays.asList(arr));

        // 输出流System.out时PrintStream对象，该对象有多个重载的println方法
        // 其中包含void println(char[] x); <- 输出包含内容而不是该引用对象地址
        // 以下默认调用toString方法，输出该引用对象地址
        System.out.println(arr);
    }
}
