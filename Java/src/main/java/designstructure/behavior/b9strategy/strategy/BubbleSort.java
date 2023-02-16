package designstructure.behavior.b9strategy.strategy;

/**
 * @ClassName Sort1BubbleSort
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:19
 * @Version 1.0
 */
public class BubbleSort implements ISort {
    @Override
    public void sort(int[] arr) {
        // 外层控制趟数:N-1趟
        // 内层控制第几趟的数组内部需要的排序次数:第i趟排序次数N-i次
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
