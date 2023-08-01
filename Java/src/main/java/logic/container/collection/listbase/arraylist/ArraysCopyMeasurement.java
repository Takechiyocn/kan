package logic.container.collection.listbase.arraylist;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组复制效率
 * System.arraycopy：本地方法(非java实现)
 * Arrays.copyOf：底层调用System.arraycopy
 * clone：Object本地方法(Object子类重写该方法使其返回相应类型，不需强制类型转换) --> 时间效率中庸
 * for：循环原始数组并直接赋值到目标数组中
 * 效率比较结论：System.arrayCopy >= clone > Arrays.copyOf > for循环
 *   1. 原始数组长度不管是多少的时候，Arrays.copyOf()的效率都比System.arraycopy()差
 *   2. 数组长度较小时候(长度几百以内)，for效率较高，随着数组长度增加，效率变低
 *   3. 数组长度中等时候(几千)，两个本地方法(System.arraycopy和clone)效率相似
 *   4. 数组长度较大时候(以万为单位)，本地方法System.arraycopy效率高
 *
 * @author moku
 */
public class ArraysCopyMeasurement {

    public static void testSystemArrayCopy(String[] orginal) {
        long start_time = System.nanoTime();
        String[] target = new String[orginal.length];
        System.arraycopy(orginal, 0, target, 0, target.length);
        long end_time = System.nanoTime();
        System.out.println("使用System.arraycopy方法耗时:" + (end_time - start_time));
    }

    public static void testArraysCopyOf(String[] orginal) {
        long start_time = System.nanoTime();
        String[] target = new String[orginal.length];
        target = Arrays.copyOf(orginal, orginal.length);
        long end_time = System.nanoTime();
        System.out.println("使用Arrays.copyOf方法耗时:" + (end_time - start_time));
    }

    public static void testClone(String[] orginal) {
        long start_time = System.nanoTime();
        String[] target = new String[orginal.length];
        target = orginal.clone();
        long end_time = System.nanoTime();
        System.out.println("使用clone方法耗时:" + (end_time - start_time));
    }

    public static void testFor(String[] orginal) {
        long start_time = System.nanoTime();
        String[] target = new String[orginal.length];
        for (int i = 0; i < orginal.length; i++) {
            target[i] = orginal[i];
        }
        long end_time = System.nanoTime();
        System.out.println("使用for循环耗时:" + (end_time - start_time));
    }

    public static void main(String args[]) {
        //输入原始数组大小
        System.out.print("原始数组的大小:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String[] original = new String[n];
        for (int i = 0; i < original.length; i++) {
            original[i] = "abcd";
        }
        testSystemArrayCopy(original);
        testArraysCopyOf(original);
        testClone(original);
        testFor(original);
    }
}
