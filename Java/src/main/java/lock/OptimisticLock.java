package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁
 *   操作数据时非常乐观，认为别人不会同时修改数据，因此不会上锁。
 *   只在执行更新时判断在此期间数据是否有修改，如有则放弃执行操作
 *   实现方式：
 *     a. CAS机制
 *     b. 版本号机制
 * 悲观锁
 *   操作数据时非常悲观，认为别人会同时修改数据，操作数据时直接把数据锁住，直到操作完成后释放锁
 *   上锁期间别人不能修改数据
 *   实现方式：
 *    a. 代码块加锁，如Java的Synchronized关键字
 *    b. 对数据加锁，如MySQL中的排它锁
 *
 * CAS(Compare And Swap)操作数:
 *  a.需要读写的内存内置V
 *  b.进行比较的预期值A
 *  c.拟写入的新值B
 * 操作逻辑：
 *  if V==A，则V==B
 *  else do nothing
 *  许多CAS操作都是自旋的，即操作不成功则一直重试直到成功为止
 * CAS原子性：
 *   Compare和Swap两个操作是CPU支持的原子性操作，即硬件层面支持
 * @author moku
 */
public class OptimisticLock {
    // 不使用锁
    private static int value1 = 0;
    // 乐观锁
    private static AtomicInteger value2 = new AtomicInteger(0);
    // 悲观锁
    private static int value3 = 0;

    // 悲观锁
    private static synchronized void increaseValue3() {
        value3++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i< 10000; i++) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value1++;
                value2.getAndIncrement();
                increaseValue3();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("线程不安全：" + value2);
        System.out.println("乐观锁(AtomicInteger)：" + value2);
        System.out.println("悲观锁(synchronized)：" + value3);
    }
}
