package logic.designstructure.behavior.b5mediator;

/**
 * @ClassName Player
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:42
 * @Version 1.0
 */
public class Player {
    public int money = 100;
    public Group group;

    public Player(Group group) {
        this.group = group;
    }

    public void change(int money) {
        // 输家将钱发到群里
        group.money -= money;
        // 赢家从群里领取
        this.money += money;
    }
}
