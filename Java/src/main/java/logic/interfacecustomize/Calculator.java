package logic.interfacecustomize;

/**
 * 自定义函数式接口
 * @author moku
 * @param <T>
 */
@FunctionalInterface
public interface Calculator<T> {
    /**
     * test
     * @param t1 test
     * @param t2 test
     * @return  test
     */
    T operation(T t1, T t2);
}
