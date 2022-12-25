package designstructure.behavior.b7observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Observable
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:27
 * @Version 1.0
 */
public class Observable {
    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * @Params:[o]
     * @Returns:void
     */
    public void addObserver(Observer o){
        observers.add(o);
    }

    /**
     * 移除观察者
     * @Params:[o]
     * @Returns:void
     */
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    /**
     * 通知所有观察者有事件发生
     * @Params:[event]
     * @Returns:void
     */
    public void notifyObservers(String event){
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
