package thread.multithread.thread;

import thread.multithread.thread.threadpool.ThreadExecutors;

/**
 * @author moku
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        ThreadExecutors executors = new ThreadExecutors();

        // 可缓存无界线程池
//        executors.newCachedThreadPool();

        // 固定线程数量线程池
//        executors.newFixedThreadPool();

        // 单线程话线程池
        executors.newSingleThreadPool();
    }


}
