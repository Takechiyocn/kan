package thread.thread.volatilebase;

/**
 * @ClassName VolatileVisibility
 * @Description
 * @Author moku
 * @Date 2022/12/15 0:42
 * @Version 1.0
 */

public class VolatileVisibility {
    // 不加volatile程序死循环，volatile可保证可见性
    private volatile static int num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            // 如果不加volatile线程对内存变化不知道
            while (num == 0) {
            }
        }).start();
        num = 1;
        System.out.println(num);
    }
}
