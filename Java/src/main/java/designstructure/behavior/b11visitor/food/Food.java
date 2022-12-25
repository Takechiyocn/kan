package designstructure.behavior.b11visitor.food;

import designstructure.behavior.b11visitor.IVisitor;

/**
 * @ClassName Food
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:34
 * @Version 1.0
 */
public abstract class Food {
    public abstract String name();

    // 接收访问者
    public abstract void accept(IVisitor visitor);
}
