package multithread.synclock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized关键字：每个对象都有一个内部锁
 *                    方法用synchronized声明，则对象的锁将保护整个方法
 * 局限性：1. 不能中断一个正在试图获得锁的线程
 *        2. 试图获得锁时不能设定超时
 *        3. 每个锁仅有单一的条件 -> 业务可能不满足
 * @author moku
 */
public class SyncBank {

    private final double[] accounts;

    public SyncBank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * synchronized：导致线程阻塞(直到线程调用该方法结束)
     * wait：线程等待(直到条件满足，即notifyAll();)
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            // 阻塞当前线程，并放弃锁 -> 其他线程可进行转账操作，以此可能满足该条件
            // 线程1：进入上述条件的等待集
            System.out.printf("***Thread await***：Transfer [%10.2f] from account[%d:%10.2f] to account[%d:%10.2f].", amount, from, accounts[from], to, accounts[to]);
            System.out.println();
            // 内部条件：添加线程到等待集
            // 内部锁只有单一条件，即只能在一处条件内设置条件对象
            wait();
            // 线程进入等待直到被通知或者经过指定时间
//            wait(1000);
        }
        System.out.print(Thread.currentThread() + ":");
        accounts[from] -= amount;
        System.out.printf("Transfer [%10.2f] from account[%d:%10.2f] to account[%d].", amount, from, accounts[from], to);
        accounts[to] += amount;
        // 调用使用相同锁（ReentrantLock）的方法：getTotalBalance
        System.out.printf("After transfer, total balance:%10.2f%n", getTotalBalance());
        // 解除等待线程的阻塞状态
        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

    /**
     *
     * @throws InterruptedException
     */
    public synchronized static void printInfo() throws InterruptedException {
        // synchronized

        // 可重入互斥锁，又称独占锁
        Lock bankLock = new ReentrantLock();
        // 条件对象：无条件阻塞
        Condition sufficientFunds = bankLock.newCondition();
        bankLock.lock();
        try {
            // 阻塞线程并添加线程到等待集
            sufficientFunds.await();
//            wait();
            System.out.println("内部锁：Bank.class对象被锁住->其他线程无法调用该方法或其他同步静态方法");
            // 因为无条件阻塞，此处解除等待线程的阻塞状态无效
            sufficientFunds.signalAll();
        } finally {
            // 因为无条件阻塞，此处释放锁无效 TODO：该函数执行完毕后自动释放？
            bankLock.unlock();
        }
    }
}
