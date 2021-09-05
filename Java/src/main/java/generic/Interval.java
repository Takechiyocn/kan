package generic;

import java.io.Serializable;

/**
 * 切换绑定顺序时，原始类型用Serializable替换，且编译器在必要时要向Comparable插入强制类型转换
 * 为提高效率，应该将标记/标签接口放在边界列表的末尾
 * @param <T>
 */
public class Interval<T extends Comparable & Serializable> implements Serializable {
    private T lower;
    private T upper;

    public Interval(T first, T second) {
        if (first.compareTo(second) <= 0) {
            this.lower = first;
            this.upper = second;
        } else {
            this.lower = second;
            this.upper = first;
        }
    }
}
