package designstructure.behavior.b9strategy.strategy;

/**
 * @ClassName Sort3InsertSort
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:28
 * @Version 1.0
 */
public class InsertSort implements ISort {
    @Override
    public void sort(int[] arr) {
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
}
