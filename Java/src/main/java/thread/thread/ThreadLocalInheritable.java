package thread.thread;

/**
 * @ClassName ThreadLocalInheritable
 * @Description
 * @Author moku
 * @Date 2022/12/19 3:40
 * @Version 1.0
 */
public class ThreadLocalInheritable {
    public static void main(String[] args) {

        final ThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("Hello");
        new Thread(() -> {
            System.out.println("获取主线程变量：" + threadLocal.get());
        }).start();
    }
}
