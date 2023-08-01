package logic.lock.spinlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName SpinLockBase
 * @Description
 * @Author moku
 * @Date 2022/12/15 14:32
 * @Version 1.0
 */
public class SpinLockBase {
    public static void main(String[] args) throws InterruptedException {

        // 定义锁：底层使用自旋的CAS
        SpinLockInAtomic lock = new SpinLockInAtomic();
        new Thread(() -> {
            lock.lockWithSpinLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unLockWithSpinLock();
            }
        },"Thread A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            lock.lockWithSpinLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unLockWithSpinLock();
            }
        },"Thread B").start();
    }
}

class SpinLockInAtomic {
    AtomicReference<Thread> ref = new AtomicReference<>();

    // 加锁
    public void lockWithSpinLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> lock the SpinLock");
        // 底层使用自旋的CAS
        while (!ref.compareAndSet(null, thread)) {
        }
    }

    // 解锁
    public void unLockWithSpinLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> unlock the SpinLock");
        ref.compareAndSet(thread, null);
    }
}
