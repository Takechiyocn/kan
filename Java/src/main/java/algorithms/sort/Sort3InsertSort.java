package algorithms.sort;

/**
 * 插入排序：假定基准值，大元素后移
 *   假定第一个元素位置正确，比较找到合适位置，即较大元素后移
 *   时间复杂度：O(n²)
 * @author moku
 */
public class Sort3InsertSort {
    public static void insertSort(int[] arr) {
        // 假定第一个元素位置正确
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 待插入元素
            int target = arr[i];
            // 后移
            while (j > 0 && target < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            // 插入元素
            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 7, 4};
        insertSort(arr);

        for (int res : arr) {
            System.out.println(res);
        }
    }
}
