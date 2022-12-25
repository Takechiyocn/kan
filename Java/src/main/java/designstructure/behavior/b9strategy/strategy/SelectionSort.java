package designstructure.behavior.b9strategy.strategy;

/**
 * @ClassName SelectionSort
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:23
 * @Version 1.0
 */
public class SelectionSort implements ISort {
    @Override
    public void sort(int[] arr) {
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
}
