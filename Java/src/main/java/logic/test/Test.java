package logic.test;

/**
 * @ClassName Test
 * @Description
 * @Author moku
 * @Date 2023/2/4 21:57
 * @Version 1.0
 */
public class Test {

    public static void sort(int[] arr) {

        int target;
        for (int i = 1; i < arr.length; i++) {
            target = arr[i];
            int j = i;
            while ( j > 0 && target < arr[j-1]) {
                arr[j] = arr[j -1];
                j--;
            }
            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 7, 4};
        sort(arr);

        for (int res : arr) {
            System.out.println(res);
        }
    }
}
