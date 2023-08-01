package logic.designstructure.behavior.b9strategy;

import logic.designstructure.behavior.b9strategy.strategy.BubbleSort;
import logic.designstructure.behavior.b9strategy.strategy.ISort;
import logic.designstructure.behavior.b9strategy.strategy.InsertSort;
import logic.designstructure.behavior.b9strategy.strategy.SelectionSort;

/**
 * @ClassName Sort
 * @Description
 * @Author moku
 * @Date 2022/12/25 11:30
 * @Version 1.0
 */
public class Sort implements ISort {
    private ISort sort;

    public Sort(SortStrategy strategy) {
        setSort(strategy);
    }

    @Override
    public void sort(int[] arr) {
        sort.sort(arr);
    }

    public void setSort(SortStrategy strategy) {
        switch (strategy) {
            case BUBBLE_SORT -> {
                sort = new BubbleSort();
                break;
            }
            case SELECTION_SORT -> {
                sort = new SelectionSort();
                break;
            }
            case INSERT_SORT -> {
                sort = new InsertSort();
                break;
            }
            default -> {
                throw new IllegalArgumentException("There's no such strategy yet...");
            }
        }
    }
}
