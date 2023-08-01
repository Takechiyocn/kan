package logic.designstructure.behavior.b9strategy;

import java.util.Arrays;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:32
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        int[] arr = new int[]{6, 1, 2, 3, 5, 4};
        Sort sort = new Sort(SortStrategy.BUBBLE_SORT);
        // 选择不同策略
        sort.setSort(SortStrategy.SELECTION_SORT);
        sort.setSort(SortStrategy.INSERT_SORT);
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
