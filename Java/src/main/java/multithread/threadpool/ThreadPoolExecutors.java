package multithread.threadpool;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * ThreadPoolExecutor方法
 *   corePoolSize：指定线程池中线程数量，决定添加的任务的处理方式
 *     1. 线程池中线程数量 < corePoolSize：开辟新线程去执行任务
 *     2. 线程池中线程数量 = corePoolSize：将任务放到workQueue队列中()
 *   maximumPoolSize：指定线程池中最大线程数量，根据workQueue类型开辟最大线程数量
 *   keepAliveTime：当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁
 *   unit：keepAliveTime单位
 *   workQueue：任务队列，被添加到线程池中但尚未被执行的任务
 *     1. 直接提交任务队列
 *     2. 有界任务队列
 *     3. 无界任务队列
 *     4. 优先任务队列
 *   threadFactory：任务工厂，用于创建线程，通常使用默认即可
 *   handler：拒绝策略；当任务太多来不及处理时，如何拒绝任务
 * @author moku
 */
public class ThreadPoolExecutors {

    /**
     * 直接提交任务队列SynchronousQueue
     * 特点：
     *   1.SynchronousQueue是特殊的BlockingQueue，没有容量
     *   2.每执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒
     *     反之每一个删除操作也需要等待对应的插入操作
     *  执行过程：
     *   1.创建新线程，直到线程数量=maximumPoolSize(SynchronousQueue队列提交的任务不会被保存，总是马上提交执行)
     *   2.执行拒绝策略
     */
    public static void synchronousQueue() {
        // maximumPoolSize设置为2
        // 拒绝策略为AbortPolish策略，直接抛出异常
        ExecutorService pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        // 当线程创建数大于maximumPoolSize时，直接执行拒绝策略抛出异常
        for (int i = 0; i < 3; i++) {
            pool.execute(() -> System.out.println("直接提交任务队列(SynchronousQueue)：" + Thread.currentThread().getName()));
        }
    }

    /**
     * 有界任务队列ArrayBlockingQueue
     * 执行过程：
     *  1. 执行新任务时，线程池创建新线程，直到线程数量=corePoolSize
     *  2. 将新任务添加到等待队列，直到等待队列满(ArrayBlockingQueue初始化容量)
     *  3. 创建新线程，直到线程数量=maximumPoolSize
     *  4. 执行拒绝策略
     * 线程池创建的最大线程数量：
     *  1. 有界队列大或者未达到超负荷状态，corePoolSize以下
     *  2. 队列满，maximumPoolSize为最大
     */
    private static void arrayBlockingQueue() {
        ExecutorService pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 3; i++) {
            pool.execute(() ->
                    System.out.println(Thread.currentThread().getName()));
        }
    }

    /**
     * 无界任务队列LinkedBlockingQueue
     * 执行过程：
     *  1. 执行新任务时，线程池创建新线程，直到线程数量=corePoolSize
     *  2. 将新任务添加到等待队列，无数量限制(maximumPoolSize参数无效)
     * 线程池创建的最大线程数量：corePoolSize
     * 缺点：注意任务提交与任务处理之间的协调，否则将导致队列任务无法处理一直增长，消耗完系统资源
     */
    private static void linkedBlockingQueue() {
        ExecutorService pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 3; i++) {
            pool.execute(() ->
                    System.out.println(Thread.currentThread().getName()));
        }
    }

    /**
     * 优先任务队列PriorityBlockingQueue
     * 执行过程：
     *  1. 执行新任务时，线程池创建新线程，直到线程数量=corePoolSize
     *  2. 将新任务添加到等待队列，无数量限制(maximumPoolSize参数无效)
     * 线程池创建的最大线程数量：corePoolSize
     * 特点：特殊的无界任务队列
     *  PriorityQueue：线程不安全
     *  PriorityBlockingQueue：线程安全
     */
    private static void priorityBlockingQueue() {
        // 优先级队列默认容量11

        ExecutorService pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 20; i++) {
            pool.execute(new ThreadTask(i));
        }
    }

    private static class ThreadTask implements Runnable, Comparable<ThreadTask> {
        private int priority;

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        public ThreadTask(int i) {
            this.priority = i;
        }

        // 当前对象和其他对象做比较，当前优先级大就返回-1，优先级小就返回1,

        /**
         * 前对象和其他对象做比较:值越小优先级越高
         *  1： 表示当前对象大于o对象
         *  0： 表示当前对象等于o对象
         *  -1： 表示当前对象小于o对象
         */
        @Override
        public int compareTo(@NotNull ThreadPoolExecutors.ThreadTask o) {
            return this.priority < o.priority ? -1 : 1;
        }

        @Override
        public void run() {
            try {
                // 让线程阻塞，使后续任务进入缓存队列
                Thread.sleep(2000);
                System.out.println("priority:" + this.priority + ",ThreadName:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 直接提交任务队列
//        synchronousQueue();

        // 有界任务队列
//        arrayBlockingQueue();

        // 无界任务队列
//        linkedBlockingQueue();

        // 优先任务队列
        priorityBlockingQueue();
    }



}
