package logic.designstructure.behavior.b7observer;

/**
 * @ClassName CriminalObservable
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:37
 * @Version 1.0
 */
public class CriminalObservable extends Observable{
    public void crime(String event) {
        System.out.println("罪犯正在" + event);
        notifyObservers(event);
    }
}
