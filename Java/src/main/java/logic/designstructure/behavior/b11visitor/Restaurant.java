package logic.designstructure.behavior.b11visitor;

import logic.designstructure.behavior.b11visitor.food.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Restaurant
 * @Description
 * @Author moku
 * @Date 2022/12/25 22:00
 * @Version 1.0
 */
public class Restaurant {
    private static List<Food> foods = new ArrayList<>();

    public Restaurant() {
        prepareFoods();
    }

    // 准备当天食物
    private void prepareFoods() {
        for (int i = 0; i < 10; i++) {
            foods.add(new Lobster());
            foods.add(new Watermelon());
            foods.add(new Steak());
            foods.add(new Banana());
        }
    }

    public void welcome(IVisitor visitor) {
        // 将食物依次提供给顾客选择
        for (Food food : foods) {
            food.accept(visitor);
        }
    }
}
