package logic.thread.thread;

/**
 * @ClassName ThreadLocalInheritable
 * @Description
 * @Author moku
 * @Date 2022/12/19 3:40
 * @Version 1.0
 */
public class ThreadLocalInheritable {
    static ThreadLocal threadLocal = new InheritableThreadLocal();
    public static void main(String[] args) {


        threadLocal.set("Hello");
        new Thread(() -> {
            System.out.println("获取主线程变量：" + threadLocal.get());
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("获取主线程变量：" + threadLocal.get());
        }).start();
        threadLocal.set("Hello2");
        System.out.println(threadLocal.get());
    }
}
