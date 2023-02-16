package algorithms.sort;

/**
 * 冒泡排序：相邻比较
 *   总数据长度N，总共进行N-1趟排序，第i趟排序次数N-i次
 *   时间复杂度：O(n²)
 * @author moku
 */
public class Sort1BubbleSort {

    public static void bubbleSort(int[] arr) {
        // 外层控制趟数:N-1趟
        // 内层控制第几趟的数组内部需要的排序次数:第i趟排序次数N-i次
        for (int i = 0; i < arr.length - 1; i++) {
            // 标记
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 如果有交换，说明还存在逆序对
                    flag = true;
                }
            }
            // 如果标记没有被改变，说明没有进行交换
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 7, 4};
        bubbleSort(arr);

        for (int res : arr) {
            System.out.println(res);
        }
    }
}
