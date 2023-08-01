package logic.generic.rawtype;

/**
 * 定义泛型类型时，自动提供了一个相应的原始类型，原始类型可按照以下步骤获取：
 *   1. 原始类型名字/类名：删除类型参数后的泛型类型名
 *   2. 擦除(erased)类型变量，并做以下替换
 *      a. 有限定类型，替换为相应限定类型(extends继承的接口/类，如<T extends Comparable>中的Comparable接口)
 *      b. 无限定类型，替换为Object
 * @author moku
 */
public class GenericTypeCommonRawType {
    private Object first;
    private Object second;

    public GenericTypeCommonRawType() {
        this.first = null;
        this.second = null;
    }

    public GenericTypeCommonRawType(Object first, Object second) {
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
