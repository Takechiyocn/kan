package logic.designstructure.behavior.b7observer;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 10:40
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        CriminalObservable zs = new CriminalObservable();
        PoliceObserver p1 = new PoliceObserver();
        PoliceObserver p2 = new PoliceObserver();
        PoliceObserver p3 = new PoliceObserver();
        // 注册观察者到容器，并监听事件(zs的动作)
        zs.addObserver(p1);
        zs.addObserver(p2);
        zs.addObserver(p3);
        zs.crime("放狗咬人");
    }
}
