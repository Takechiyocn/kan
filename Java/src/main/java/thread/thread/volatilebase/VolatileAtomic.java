package thread.thread.volatilebase;

/**
 * @ClassName VolatileAtomic
 * @Description
 * @Author moku
 * @Date 2022/12/15 0:46
 * @Version 1.0
 */
public class VolatileAtomic {
    // 不保证原子性
    private volatile static int num = 0;

    public static void add() {
        // 不保证原子性，以下拆分为两个步骤
        //   1. num+1 ->新值
        //   2. num = 新值
        num++;
    }

    public static void main(String[] args) {

        // 理论上结果应该是20000
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
                System.out.println(Thread.currentThread().getName()+ " sum:" + num);
            }).start();
        }
    }
}
