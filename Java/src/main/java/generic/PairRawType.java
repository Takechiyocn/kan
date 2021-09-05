package generic;

/**
 * 定义泛型类型时，自动提供了一个相应的原始类型
 * 即
 * 1。原始类型名字/类名：删除类型参数后的泛型类型名
 * 2. 擦除(erased)类型变量，并替换为限定(extends继承的接口/类， 如 <T extends Comparable>中的Comparable接口)类型（无限定的变量用Object替换）
 */
public class PairRawType {
    private Object first;
    private Object second;

    public PairRawType() {
        this.first = null;
        this.second = null;
    }

    public PairRawType(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object newValue) {
        first = newValue;
    }

    public void setSecond(Object newValue) {
        second = newValue;
    }

    public static Comparable min(Comparable[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Comparable smallest = a[0];
        for (Comparable t : a) {
            if (smallest.compareTo(t) > 0) {
                smallest = t;
            }
        }

        return smallest;
    }
}
