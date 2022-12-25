package designstructure.behavior.b11visitor.food;

import designstructure.behavior.b11visitor.IVisitor;

/**
 * @ClassName Lobster
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:35
 * @Version 1.0
 */
public class Lobster extends Food {
    @Override
    public String name() {
        return "lobster";
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.chooseFood(this);
    }
}
