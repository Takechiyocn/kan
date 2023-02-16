package algorithms.sort;

/**
 * 选择排序：选择最小
 *   冒泡排序优化版本
 *   通过整体选择，每趟确定整体最小值后才进行交换，即每趟排序确定一个最小值
 *   时间复杂度：O(n²)
 * @author moku
 */
public class Sort2SelectSort {

    public static void selectSort(int[] arr) {
        int minIndex = 0;
        // 只需要比较n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            // 从i+1开始比较，因为minIndex默认为i了，i就没必要比了
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 如果minIndex不为i，说明找到了更小的值，交换之
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 7, 4};
        selectSort(arr);

        for (int res : arr) {
            System.out.println(res);
        }
    }
}
