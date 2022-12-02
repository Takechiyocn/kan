package thread.multithread.thread.factory;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通用线程工厂(线程池用于创建线程)
 * @author moku
 */
public class ThreadPoolFactory implements ThreadFactory {
    private AtomicInteger threadIndex = new AtomicInteger(0);
    private String threadNamePrefix;

    public ThreadPoolFactory(String prefix) {
        this.threadNamePrefix = prefix;
    }

    @Override
    public Thread newThread(@NotNull Runnable r) {
       Thread thread = new Thread(r);
       thread.setName(threadNamePrefix + "-xxljob-" + threadIndex.getAndIncrement());
       return thread;
    }
}
