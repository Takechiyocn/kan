package logic.designstructure.behavior.b4iterator;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MyList
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:28
 * @Version 1.0
 */
public class MyList implements Iterable<String> {
    private List<String> data = new ArrayList<>(Arrays.asList("a", "b", "c"));

    // 每次生成一个新的迭代器，用于遍历列表
    @NonNull
    @Override
    public java.util.Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements java.util.Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public String next() {
            return data.get(index++);
        }
    }
}
