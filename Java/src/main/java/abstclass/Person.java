package abstclass;

/**
 * @description: TODO: 为什么要抽象类
 *                     对共有的部分进行更高层次的共通化
 * @author: Kan
 * @date: 2021/2/16 0:47
 */
public abstract class Person {

    private final String name;
    private final int age = 20;

    /**
     * 构造体
     *
     * @param name name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * 使用abstract修饰的方法不能有方法体
     *
     * @return 实现类定义的String字符串
     */
    public abstract String getDescription();

    /**
     * 未使用abstract修饰的方法可以有方法体
     * final：不允许子类覆盖这个方法(改变语义，亦即修改name值)
     *
     * @return name
     */
    public final String getName() {
        return name;
    }
}
