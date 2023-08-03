package logic.thread.thread;

import java.util.stream.IntStream;

/**
 * @ClassName ThreadPriority
 * @Description 线程优先级(1 ~ 10)：默认为5
 *              线程优先级和执行顺序无关，由操作系统的线程调度算法决定（高优先级线程更大几率优先执行）
 * @Author moku
 * @Date 2022/12/23 2:18
 * @Version 1.0
 */
public class ThreadPriority {
    public static void main(String[] args) {

        // 线程优先级大于线程所属线程组优先级时，线程优先级失效
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup1");
        threadGroup.setMaxPriority(6);

        // 线程优先级设置
        IntStream.range(1, 10).forEach(i -> {
            // 设置线程所属线程组
            Thread t = new Thread(threadGroup, () -> {
                System.out.println(Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + " priority:" + Thread.currentThread().getPriority());
            });
            t.setPriority(i);
            t.start();
        });

        // 线程数组复制
        Thread[] threadArray = new Thread[threadGroup.activeCount()];
        ThreadGroup threadGroup2 = new ThreadGroup("ThreadGroup2");
        threadGroup2.enumerate(threadArray);

        // 线程组统一处理异常
        ThreadGroup threadGroup3 = new ThreadGroup("ThreadGroup3") {
            // 捕获线程抛出的unchecked异常
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(Thread.currentThread().getThreadGroup() + t.getName() + " uncaughtException:" + e.getMessage());
            }
        };
        new Thread(threadGroup3, () -> {
            throw new RuntimeException("test");
        }).start();
    }
}
