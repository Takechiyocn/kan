package test;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description
 * @Author moku
 * @Date 2023/2/4 21:57
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("sb1");
        StringBuffer sb2 = new StringBuffer("sb2");

        System.out.println(sb1);
        System.out.println(sb2);

        sb1 = sb2;
        System.out.println(sb1);
        String s = "aa";
        final byte[] a = {'a','b'};
        final byte[] b = {'c','d'};
        a[0] = 'e';
        System.out.println(Arrays.toString(a));
    }
}
