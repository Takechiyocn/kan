package abstclass;

/**
 * @description: 抽象类：对共有部分进行更高层次的共通化
 *               定义：抽象方法即没有方法体的方法且用abstract修饰。
 *                    抽象方法的类就是抽象类，抽象类也必须用abstract修饰。
 *               抽象类使用原则：
 *                    1. 抽象类必须有子类，使用extends继承，一个子类只能继承一个抽象类
 *                    2. 抽象类不能直接实例化(因为抽象方法没有方法体，无法调用方法体)，需要依靠子类采用向上转型的方式处理
 *                    3. 子类必须覆写(overwrite)抽象类中的全部抽象方法(如果子类没有实现父类的抽象方法，则子类也必须定义为抽象类)
 *                    4. 抽象方法必须为public或protected类型(如果为private或者默认类型，则该方法无法被子类继承)，缺省为public类型
 *               为什么要使用抽象类：
 *                    1. 使用抽象类而不使用普通超类，抽象类中的抽象方法必须由子类去覆写，而不是使用超类中定义的空方法体。
 *                    2. 使用抽象类，类的使用者在创建对象时，就必须知道具体使用哪个子类，而不误用可能不完整的超类。
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
     * 抽象方法没有方法体
     *
     * @return 实现类定义的String字符串
     */
    public abstract String getDescription();

    /**
     * 非抽象方法(不用abstract修饰)可以有方法体
     * final：不允许子类覆盖这个方法(改变语义，亦即修改name值)
     *
     * @return name
     */
    public final String getName() {
        return name;
    }
}
