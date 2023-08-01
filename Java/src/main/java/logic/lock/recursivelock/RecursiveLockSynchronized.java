package logic.lock.recursivelock;

/**
 * @ClassName RecursiveLockSynchronized
 * @Description 可重入锁/递归锁
 * @Author moku
 * @Date 2022/12/15 14:20
 * @Version 1.0
 */
public class RecursiveLockSynchronized {

    // Synchronized
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sms();
        }, "A").start();
        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }
}

class Phone {
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName()
                + "sms");
        // 这里也有锁(sms锁 里面的call锁)
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName()
                + "call");
    }
}

