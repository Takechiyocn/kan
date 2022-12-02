package thread.thread;

/**
 * 普通线程创建
 *   1. 继承Thread类
 *   2. 实现Runnable接口
 *
 * @author moku
 */
public class ThreadBase {

    public static void main(String[] args) throws InterruptedException {

        // 继承Thread：t1是一个Thread对象
        ThreadExtends t1 = new ThreadExtends();
        t1.start();

        // 实现Runnable接口
        ThreadImplements t2 = new ThreadImplements();
//        new Thread(Runnable target).start();
        new Thread(t2).start();

        // Lambda表达式
        ThreadLambda t3 = new ThreadLambda();
        t3.newThread();
    }
}

/**
 * 继承Thread
 * 内部类
 *
 */
class ThreadExtends extends Thread {
    @Override
    public void run() {
        System.out.println("普通线程(继承Thread)");
    }
}

/**
 * 实现Runnable接口
 * 内部类
 *
 */
class ThreadImplements implements Runnable {

    @Override
    public void run() {
        System.out.println("普通线程(实现Runnable接口)");
    }
}

class ThreadLambda {

    public void newThread() throws InterruptedException {
        // run() = try{} catch{}
        Runnable r = () -> {
            try {
                // 阻塞新线程
                // Thread.sleep(60000);

                while (!Thread.currentThread().isInterrupted()) {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Thread 2, count: " + i);
                    }
                    // 接收到中断请求时，新线程处于sleep阻塞状态 -> 中断异常抛出
                    Thread.sleep(50000);
                }
            } catch (InterruptedException e) {
                // Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();

        // 5s后给新线程发送中断请求
        Thread.sleep(5000);
        t.interrupt();
    }
}

