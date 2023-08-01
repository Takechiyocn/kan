package logic.lock;

/**
 * @ClassName MutexLock
 * @Description synchronized实现互斥锁
 *              当多个代码片被synchronized块修饰后，这些同步块的同步监听器对象又是同一个时
 *              这些代码片端就是互斥的，多个线程不能同时在这些方法中运行
 * @Author moku
 * @Date 2023/3/1 10:09
 * @Version 1.0
 */
public class MutexLock {

    public static void main(String[] args) {
        Boo boo = new Boo();
        Thread t1 = new Thread() {
            public void run() {
                boo.methodA();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                boo.methodB();
            }
        };
        t1.start();
        t2.start();

    }
}

class Boo {
    public synchronized void methodA() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ":正在运行dosome1方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ":正在运行dosome方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}