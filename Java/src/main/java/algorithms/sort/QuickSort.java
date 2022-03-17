package algorithms.sort;

/**
 * 快速排序
 *
 *
 *   时间复杂度：O(nlgn)
 * @author moku
 */
public class QuickSort {

   public static void quickSort(int[] arr) {
       int len = arr.length;
       int left = 0;
       int right = len - 1;
       quickSortCore(arr, left, right);
   }

    private static void quickSortCore(int[] arr, int left, int right) {
        // 基准数已经是最小数，该轮无需递归
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 基准数：默认最左元素
        int base = arr[left];
        // 左右指针未相遇
        while (i != j) {
            // 从右查找比基准数小的元素(以下判断需添加=，因为不知道是否已经交换过元素)
            while (arr[j] >= base && i < j) {
                j--;
            }
            // 从左查找比基准数大的元素
            while (arr[i] <= base && i < j) {
                i++;
            }
            // 找到了相应位置则交换两个元素位置
            // i>=j则结束该轮递归
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 左右指针相遇或者i>=j，将基准数放到中间位置
        arr[left] = arr[i];
        arr[i] = base;
        // 递归
        quickSortCore(arr, left, i - 1);
        quickSortCore(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 7, 4};
        quickSort(arr);

        for (int res : arr) {
            System.out.println(res);
        }
    }
}
