package designstructure.behavior.b11visitor;

import designstructure.behavior.b11visitor.food.Banana;
import designstructure.behavior.b11visitor.food.Lobster;
import designstructure.behavior.b11visitor.food.Steak;
import designstructure.behavior.b11visitor.food.Watermelon;

/**
 * @ClassName IVisitor
 * @Description 暴露接口供人访问
 * @Author moku
 * @Date 2022/12/25 22:02
 * @Version 1.0
 */
public interface IVisitor {
    void chooseFood(Lobster lobster);
    void chooseFood(Watermelon watermelon);
    void chooseFood(Steak steak);
    void chooseFood(Banana banana);
}
