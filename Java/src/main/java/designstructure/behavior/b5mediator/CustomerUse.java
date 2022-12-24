package designstructure.behavior.b5mediator;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:45
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        Group group = new Group();
        Player p1 = new Player(group);
        Player p2 = new Player(group);
        Player p3 = new Player(group);
        Player p4 = new Player(group);

        p1.change(40);
        p2.change(20);
        p3.change(-10);
        p4.change(-50);

        System.out.println("四人剩余钱：" + p1.money
                + "," + p2.money
                + "," + p3.money
                + "," + p4.money);
    }
}
