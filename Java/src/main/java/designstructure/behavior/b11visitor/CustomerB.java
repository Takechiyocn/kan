package designstructure.behavior.b11visitor;

import designstructure.behavior.b11visitor.food.Banana;
import designstructure.behavior.b11visitor.food.Lobster;
import designstructure.behavior.b11visitor.food.Steak;
import designstructure.behavior.b11visitor.food.Watermelon;

/**
 * @ClassName CustomerB
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:06
 * @Version 1.0
 */
public class CustomerB implements IVisitor {
    @Override
    public void chooseFood(Lobster lobster) {
        System.out.println("Customer B doesn't like " + lobster.name());
    }

    @Override
    public void chooseFood(Watermelon watermelon) {
        System.out.println("Customer B doesn't like " + watermelon.name());
    }

    @Override
    public void chooseFood(Steak steak) {
        System.out.println("Customer B gets a " + steak.name());
    }

    @Override
    public void chooseFood(Banana banana) {
        System.out.println("Customer B gets a " + banana.name());
    }
}
