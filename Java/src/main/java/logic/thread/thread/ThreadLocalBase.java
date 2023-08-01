package logic.thread.thread;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 线程局部变量ThreadLocal：避免共享变量，为每个线程提供各自的实例
 *
 * @author moku
 */
public class ThreadLocalBase {

    // SimpleDateFormat不是线程安全
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    // 使用线程局部变量ThreadLocal
    // withInitial:创建线程局部变量（各个线程都有属于自己的一个该变量）
    private static final ThreadLocal<SimpleDateFormat> dateFormat2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    private static final CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {

        // 线程安全的HashSet：带去重功能
        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i < 100; i++) {
            Runnable r = (() -> {
                // 给定线程首次调用get时，会调用initialValue方法。
                // 此后get方法返回特定于当前线程的实例，即每个线程拥有自己的变量值。
                String dateStamp = dateFormat.format(new Date());
                String dateStamp2 = dateFormat2.get().format(new Date());
                System.out.println(Thread.currentThread() + ", Time by SimpleDateFormat:" + dateStamp);
                System.out.println(Thread.currentThread() + ", Time by ThreadLocal<SimpleDateFormat>:" + dateStamp2);
                dates.add(dateStamp);

                // java.util.Random线程安全：
                //  如果多个线程需要等待一个共享的随机数生成器会很低效(因为线程安全，其他线程要等待前面线程生成结束后才能获取锁)
                // ThreadLocalRandom.current返回特定于当前线程的Random类实例
                int random = ThreadLocalRandom.current().nextInt(100);
                System.out.println("ThreadLocalRandom integer：" + random);
                countDownLatch.countDown();
            });

            Thread t = new Thread(r);
            t.start();
        }

        // 阻塞，直到countDown数量为0
        countDownLatch.await();
        // 100个线程各执行一次，想定最后dates保存100条数据，实际数据总数远小于100
        // static定义的SimpleDateFormat是一个共享变量，SimpleDateFormat内部通过成员变量calendar来保存时间，calendar可以被多个线程访问
        // 线程1执行完calendar.setTime设置时间后，还没等后续执行；线程2又执行了calendar.setTime;
        // 此时线程1、线程2的calendar.getTime获取到相同值，导致dates总数变少
        // -> 因为线程不安全，所以不能将SimpleDateFormat作为共享变量使用
        System.out.println(dates.size());
    }
}
