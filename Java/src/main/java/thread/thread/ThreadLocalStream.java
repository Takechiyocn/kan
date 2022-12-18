package thread.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName ThreadLocalStream
 * @Description
 * @Author moku
 * @Date 2022/12/17 2:35
 * @Version 1.0
 */
public class ThreadLocalStream {
    public static void main(String[] args) {
        // 新建一个ThreadLocal变量
        ThreadLocal<String> local = new ThreadLocal<>();
        // 新建一个随机数类(线程安全)
        Random random = new Random();
        // Java8新特性：Stream
        IntStream.range(0,5).forEach(i -> new Thread(() -> {
            // 为每个线程设置local值
            local.set(i + ", " + random.nextInt(10));
            System.out.println("线程和local值分别为[" + local.get() + "]");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A" + i).start());
    }
}
