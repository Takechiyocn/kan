package multithread.implicitlylock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;
    private Lock bankLock;
    // 条件对象/条件变量(condition variable)
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        // 可重入锁
        bankLock = new ReentrantLock();
        // 资金条件对象
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                // 阻塞当前线程，并放弃锁 -> 其他线程可进行转账操作，以此可能满足该条件
                // 线程1：进入上述条件的等待集
                System.out.printf("***Thread await***：Transfer [%10.2f] from account[%d] to account[%d].", amount, from, to);
//                System.out.println();
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread() + ":");
            accounts[from] -= amount;
            System.out.printf("Transfer [%10.2f] from account[%d] to account[%d].", amount, from, to);
            accounts[to] += amount;
            // 调用使用相同锁（ReentrantLock）的方法：getTotalBalance
            System.out.printf("After transfer, total balance:%10.2f%n", getTotalBalance());
            // 线程2：激活因同一条件(sufficientFunds)而等待的所有线程即线程集(如线程1等)
            //       1. 将等待线程从线程集中移出 -> 等待线程成为可运行状态
            //       2. 调度器再度激活上述线程
            //       3. 上述线程重新进入该对象，等待可用的锁
            //       4. 某个线程从await调用返回，获取锁并从被阻塞的地方继续执行
            //       5. 线程再次测试该条件（signalAll只是通知等待线程：条件可能已经满足）
            //          a. 如果条件仍不满足，该线程再次被阻塞
            //          b. TODO：如果条件满足，该线程执行完后，应唤醒其他所有被解除阻塞状态的线程，继续测试？
            // -> 线程1调用该方法时，由于是该对象的第一个执行的线程，所以没有被阻塞的其他线程
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        // 锁的重入：锁计数器+1
        bankLock.lock();
        try {
            double sum = 0;

            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
