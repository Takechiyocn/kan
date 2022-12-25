package designstructure.behavior.b11visitor;

import designstructure.behavior.b11visitor.food.Banana;
import designstructure.behavior.b11visitor.food.Lobster;
import designstructure.behavior.b11visitor.food.Steak;
import designstructure.behavior.b11visitor.food.Watermelon;

/**
 * @ClassName CustomerA
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:06
 * @Version 1.0
 */
public class CustomerA implements IVisitor {
    @Override
    public void chooseFood(Lobster lobster) {
        System.out.println("Customer A gets a " + lobster.name());
    }

    @Override
    public void chooseFood(Watermelon watermelon) {
        System.out.println("Customer A gets a " + watermelon.name());
    }

    @Override
    public void chooseFood(Steak steak) {
        System.out.println("Customer A doesn't like " + steak.name());
    }

    @Override
    public void chooseFood(Banana banana) {
        System.out.println("Customer A doesn't like " + banana.name());
    }
}
