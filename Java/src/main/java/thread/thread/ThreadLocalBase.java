package thread.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程局部变量ThreadLocal：避免共享变量，为每个线程提供各自的实例
 *
 * @author moku
 */
public class ThreadLocalBase {

    // SimpleDateFormat不是线程安全
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    // 使用线程局部变量ThreadLocal
    // withInitial:创建线程局部变量（各个线程都有属于自己的一个该变量）
    public static final ThreadLocal<SimpleDateFormat> dateFormat2 =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Runnable r = (
                    () -> {
                        // 给定线程首次调用get时，会调用initialValue方法。
                        // 此后get方法返回特定于当前线程的实例，即每个线程拥有自己的变量值。
                        String dateStamp = dateFormat.format(new Date());
                        String dateStamp2 = dateFormat2.get().format(new Date());
                        System.out.println(Thread.currentThread() + ", Time by SimpleDateFormat:" + dateStamp);
                        System.out.println(Thread.currentThread() + ", Time by ThreadLocal<SimpleDateFormat>:" + dateStamp2);

                        // java.util.Random线程安全：
                        //  如果多个线程需要等待一个共享的随机数生成器会很低效(因为线程安全，其他线程要等待前面线程生成结束后才能获取锁)
                        // ThreadLocalRandom.current返回特定于当前线程的Random类实例
                        int random = ThreadLocalRandom.current().nextInt(100);
                        System.out.println("ThreadLocalRandom integer：" + random);
                    }
            );

            Thread t = new Thread(r);
            t.start();
        }
    }
}
