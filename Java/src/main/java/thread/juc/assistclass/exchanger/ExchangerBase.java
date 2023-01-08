package thread.juc.assistclass.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ExchangerBase
 * @Description
 * @Author moku
 * @Date 2023/1/8 11:05
 * @Version 1.0
 */
public class ExchangerBase {

    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                String ware = "商品";
                System.out.println("摊贩准备卖东西：");
                TimeUnit.SECONDS.sleep(2);
//                String money = exchanger.exchange(ware);
                // 阻塞线程等待超时
                String money = null;
                money = exchanger.exchange(ware, 1000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "：摊贩贩卖商品得到了[" + money + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            String money = "人民币";
            System.out.println("顾客准备买东西：");
            try {
                TimeUnit.SECONDS.sleep(4);
                String ware = exchanger.exchange(money);
                System.out.println(Thread.currentThread().getName() + "：顾客用人民币购买了[" + ware + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
