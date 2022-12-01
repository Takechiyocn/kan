package multithread;

/**
 * @author moku
 */
public class ThreadBase {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread 1");

        // run() = try{} catch{}
        Runnable r = () -> {
            try {
                // 阻塞新线程
//                Thread.sleep(60000);

                while (!Thread.currentThread().isInterrupted()) {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Thread 2, count: " + i);
                    }
                    // 接收到中断请求时，新线程处于sleep阻塞状态 -> 中断异常抛出
                    Thread.sleep(50000);
                }
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
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
