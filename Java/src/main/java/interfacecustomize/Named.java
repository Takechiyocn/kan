package interfacecustomize;

/**
 * @description: Functional Interface标记为函数式接口(只有一个抽象方法)
 * @author: Kan
 * @date: 2021/2/27 22:25
 */
@FunctionalInterface
public interface Named {
    // 不能包含实例域或静态方法
    // 可包含常量
    // 接口内的方法自动成为public，域自动成为public static final -->通常省略

    /**
     * JDK 8 新特征 interface中允许使用default修饰方法，来完成对于方法的默认定义，该方法可以有方法体
     * 实现类可以不用覆盖默认方法，若实现类继承多处相同的方法，则实现类应明确指定使用哪种方法
     *
     * @return name
     */
    default String getName() {
        return getClass().getName() + "_" + hashCode() + "called Named implements";
    }

    /**
     * 实现类应覆盖该方法
     * 默认方法以外的方法不能有方法体：TODO：Comparator.java中有非默认方法存在方法体
     * 以下方法省略public
     * @return
     */
    String getDescription();
}
