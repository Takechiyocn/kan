package logic.designstructure.behavior.b7observer;

/**
 *
 * @ClassName Observer
 * @Description 观察者接口
 * @Author moku
 * @Date 2022/12/25 10:24
 * @Version 1.0
 */
public interface Observer {
    /**
     * 对被观察事件作出响应
     * @param event event
     */
    void update(String event);
}
