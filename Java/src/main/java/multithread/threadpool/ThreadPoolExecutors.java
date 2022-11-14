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
 * 线程池数量NThreads：
 *  NCpu=CPU数量
 *  UCpu=目标CPU使用率，0<UCpu<1
 *  W/C=任务等待时间与任务计算时间的比率
 *  NThreads=NCpu*UCpu*(1+W/C)
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

        // 安全关闭线程池：线程池中所有任务执行完毕后退出
        pool.shutdown();
    }

    /**
     * 有界任务队列ArrayBlockingQueue：为防止资源耗尽，通常采用有界任务队列+自定义拒绝策略
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

        pool.shutdown();
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
                2,
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

        /**
         * 当前对象和其他对象做比较:值越小优先级越高
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

    /**
     * handler拒绝策略
     *   1. AbortPolish：直接抛出异常
     *   2. CallerRunPolish：线程池数量达到上限后，把任务队列中的任务放在调用者线程当中执行
     *   3. DiscardOldestPolish：丢弃任务队列中最老的一个任务(最先被添加的任务，即马上要执行的任务)，并尝试再次提交
     *   4. DiscardPolish：丢弃无法处理的任务，不予任何处理。业务场景需允许任务丢失
     *   5. 自定义拒绝策略
     */
    public static void customRejectedExceptionHandler() {
        ExecutorService pool = new ThreadPoolExecutor(
                1,
                2,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("执行了自定义拒绝策略");
                    }
                }
        );
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                try {
                    // 让线程阻塞，使后续任务进入缓存队列
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread name:" + Thread.currentThread().getName());
            });
        }
    }

    /**
     * 自定义线程工厂
     */
    public static void customThreadFactory() {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                4,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                (Runnable r) -> {
                    System.out.println("线程" + r.hashCode() + "创建");
                    return new Thread(r, "threadPool" + r.hashCode());
                },
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 10; i++) {
            pool.execute(() ->
                    System.out.println("ThreadName:" + Thread.currentThread().getName())
            );
        }
    }

    private static class ThreadTask2 implements Runnable {
        public String taskName;

        public ThreadTask2(String taskName) {
            this.taskName = taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getTaskName() {
            return taskName;
        }

        @Override
        public void run() {
            System.out.println("TaskName" + this.getTaskName() + "---ThreadName:" + Thread.currentThread().getName());
        }
    }

    /**
     * ThreadPoolExecutor扩展
     */
    public static void threadPoolExecutorExtend() {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                4,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                (Runnable r) -> {
                    System.out.println("线程" + r.hashCode() + "创建");
                    return new Thread(r, "threadPool" + r.hashCode());
                },
                new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((ThreadTask2) r).getTaskName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完毕：" + ((ThreadTask2) r).getTaskName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for (int i = 0; i < 10; i++) {
            // CallerRunsPolicy:线程池数量达到上限后，把任务队列中的任务放在调用者线程当中执行
            pool.execute(new ThreadTask2("Task" + i));
        }
        // 安全关闭线程池：线程池中所有任务执行完毕后退出
        pool.shutdown();
    }

    public static void main(String[] args) {
        // 直接提交任务队列/可缓存无界线程池
//        synchronousQueue();

        // 有界任务队列
//        arrayBlockingQueue();

        // 无界任务队列
//        linkedBlockingQueue();

        // 优先任务队列
//        priorityBlockingQueue();

        // 自定义拒绝策略
        customRejectedExceptionHandler();

        // 自定义线程工厂
//        customThreadFactory();

        // ThreadPoolExecutor扩展
//        threadPoolExecutorExtend();
    }
}
