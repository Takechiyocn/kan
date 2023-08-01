package logic.thread.juc.locks.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockBase
 * @Description 默认非公平锁
 * @Author moku
 * @Date 2022/12/3 14:33
 * @Version 1.0
 */
public class ReentrantLockBase {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {for (int i = 0; i < 40; i++) {ticket.sale();}}, "a").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) {ticket.sale();}}, "b").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) {ticket.sale();}}, "c").start();
    }
}

class Ticket {
    private int ticketNum = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (this.ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "购得第[" + ticketNum--
                        + "]张票，剩余[" + ticketNum + "]张票");
            }
            // 增加错误几率
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
