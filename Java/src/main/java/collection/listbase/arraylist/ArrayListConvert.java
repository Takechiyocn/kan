package collection.listbase.arraylist;

/**
 * length属性：数组长度
 * length()方法：字符串长度
 * size()方法：泛型元素个数
 * @author moku
 */
public class ArrayListConvert {
    public void arrayListConvert(int[] arr) {
        int temp;

        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
