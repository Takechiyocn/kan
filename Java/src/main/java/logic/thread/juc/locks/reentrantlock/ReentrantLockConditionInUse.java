package logic.thread.juc.locks.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockConditionBase
 * @Description Condition精准的通知和唤醒线程
 * @Author moku
 * @Date 2022/12/3 15:12
 * @Version 1.0
 */
public class ReentrantLockConditionInUse {
    public static void main(String[] args) {

        SupplierConsumer2 sc = new SupplierConsumer2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.C();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread C").start();
    }
}

/**
 * 生产者消费者模式(完成加1减一各一次操作)
 *
 */
class SupplierConsumer2 {
    public int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void A() throws InterruptedException {
        lock.lock();
        try {
            // 业务代码，判断=>执行=>通知！
            while (num!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>AAAAA");
            num = 2;
            // 唤醒指定的线程，B
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void B() throws InterruptedException {
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            num = 3;
            System.out.println(Thread.currentThread().getName()+"=>BBBBB");
            // 唤醒指定的线程，C
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void C() throws InterruptedException {
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
            }
            num = 1;
            System.out.println(Thread.currentThread().getName()+"=>CCCCC");
            // 唤醒指定的线程，A
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
