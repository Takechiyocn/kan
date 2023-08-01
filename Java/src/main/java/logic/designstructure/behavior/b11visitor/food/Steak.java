package logic.designstructure.behavior.b11visitor.food;

import logic.designstructure.behavior.b11visitor.IVisitor;

/**
 * @ClassName Steak
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:35
 * @Version 1.0
 */
public class Steak extends Food {
    @Override
    public String name() {
        return "steak";
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.chooseFood(this);
    }
}
