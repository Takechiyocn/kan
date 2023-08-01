package logic.designstructure.behavior.b7observer;

/**
 * @ClassName PoliceObserver
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:36
 * @Version 1.0
 */
public class PoliceObserver implements Observer {
    @Override
    public void update(String event) {
        System.out.println("警察收到消息，犯罪在" + event);
    }
}
