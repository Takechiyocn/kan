package lock.recursivelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName RecursiveLockReentrantLock
 * @Description
 * @Author moku
 * @Date 2022/12/15 14:23
 * @Version 1.0
 */
public class RecursiveLockReentrantLock {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
}

class Phone2 {
    Lock lock = new ReentrantLock();

    public void sms() {
        lock.lock();
        // 细节问题：lock.lock(); lock.unlock();
        // lock 锁必须配对，否则就会死在里面
        // 两个lock() 就需要两次解锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + "sms");
            // 这里也有锁
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
