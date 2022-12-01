package multithread.thread.threadpool;

import multithread.thread.factory.ThreadPoolFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 方法对比
 *  工厂方法	                corePoolSize    maximumPoolSize	    keepAliveTime	workQueue
 *  newCachedThreadPool	    0	            Integer.MAX_VALUE	60s             SynchronousQueue:直接提交任务队列
 *  newFixedThreadPool	    nThreads	    nThreads	        0	            LinkedBlockingQueue:无界队列
 *  newSingleThreadExecutor	1	            1	                0	            LinkedBlockingQueue:无界队列
 *  newScheduledThreadPool	corePoolSize	Integer.MAX_VALUE	0	            DelayedWorkQueue:
 *
 * @author moku
 */
public class ThreadExecutors {

    /**
     * 可缓存无界线程池
     *   1. 当线程池中线程空闲时间超过60s则自动回收该线程，核心线程数为0
     *   2. 当任务超过线程池的线程数则创建新线程
     *   3. 线程池上限为Integer.MAX_VALUE，可看作无限大
     */
    public void newCachedThreadPool() {
        // 创建可缓存无界线程池，可指定线程工厂，也可使用默认线程工厂
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadPoolFactory("CachedThread"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("CacheThreadPool");
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * 固定线程数量线程池
     *   1. 可指定线程数大小，超出线程在LinkedBlockingQueue阻塞队列中等待
     *   2. 线程核心数可指定(nThreads)，空闲时为0
     */
    public void newFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadPoolFactory("FixedThreadPool"));
        for ( int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("FixedThreadPool");
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * 单线程化线程池
     * 特点：
     *   1. 串行执行所有任务
     *   2. 线程异常结束，新线程替代
     */
    public void newSingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadPoolFactory("SingleThreadPool"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("SingleThreadPool");
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * 定时周期线程池
     *   1. 可指定线程数大小，最大线程数Integer.MAX_VALUE
     *   2. 线程核心数可指定
     *
     * schedule(Runnable command, long delay, TimeUnit unit)，延迟一定时间后执行Runnable任务
     * schedule(Callable callable, long delay, TimeUnit unit)，延迟一定时间后执行Callable任务
     * scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)，延迟一定时间后，以间隔period时间的频率周期性地执行任务
     * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,TimeUnit unit)，与scheduleAtFixedRate()方法很类似，
     *   但是不同的是scheduleWithFixedDelay()方法的周期时间间隔是以上一个任务执行结束到下一个任务开始执行的间隔，而scheduleAtFixedRate()方法的周期时间间隔是以上一个任务开始执行到下一个任务开始执行的间隔，
     *   也就是这一些任务系列的触发时间都是可预知的。
     */
    public void newScheduledThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5, new ThreadPoolFactory("ScheduledThreadPool"));

        // 定时执行一次的任务(Runnable()任务)，延迟一定时间后执行
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", delay 1s by Runnable");
            }
        }, 1, TimeUnit.SECONDS);

        // 延迟一定时间后执行Runnable()任务. Lambda表达式：schedule多个方法，强制类型转换以确定具体调用方法
        executorService.schedule((Runnable) () ->
                        System.out.println(Thread.currentThread().getName() + ", delay 1s by Runnable lambda")
                , 1, TimeUnit.SECONDS);

        // 延迟一定时间后执行Callable()任务
        executorService.schedule((Callable) () -> {
                    System.out.println(Thread.currentThread().getName() + ", delay 1s by Callable");
                    return null;
                },
                1, TimeUnit.SECONDS);

        // 延迟2秒后，每3秒执行指定任务
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + ", delay 2s, every 3s execute");
        }, 2, 3, TimeUnit.SECONDS);

        // 延迟1秒后，每2秒执行指定任务
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m");
                System.out.println("scheduleWithFixedDelay执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
