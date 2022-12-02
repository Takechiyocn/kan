package thread.multithread.reentranttrylock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTryBank {

    private final double[] accounts;
    private Lock bankLock;
    // 条件对象/条件变量(condition variable)
    private Condition sufficientFunds;

    public ReentrantTryBank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        // 可重入锁
        bankLock = new ReentrantLock();
        // 资金条件对象
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        // lock方法不能被中断：因为如果一个线程在等待获得一个锁时被中断，中断线程(想获取锁的线程)在获得锁之前一直处于被阻塞状态
        //                   如果出现死锁，lock方法就无法终止。
        // tryLock:试图申请一个锁，成功后返回true，否则返回false。返回false时，线程可以继续做其他事情
        //  -> 该线程被阻塞，当条件满足时可能会解除阻塞状态
        if (bankLock.tryLock()) {
            try {
                while (accounts[from] < amount) {
                    // 阻塞当前线程，并释放锁 -> 其他线程可进行转账操作，以此可能满足该条件
                    // 线程1：进入上述条件的等待集
                    System.out.printf("***Thread await***：Transfer [%10.2f] from account[%d] to account[%d].", amount, from, to);
                    sufficientFunds.await();
                }
                System.out.print(Thread.currentThread() + ":");
                accounts[from] -= amount;
                System.out.printf("Transfer [%10.2f] from account[%d] to account[%d].", amount, from, to);
                accounts[to] += amount;
                // 调用使用相同锁（ReentrantLock）的方法：getTotalBalance
                System.out.printf("After transfer, total balance:%10.2f%n", getTotalBalance());
                sufficientFunds.signalAll();
            } finally {
                // 释放锁
                bankLock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread() + ", try lock.");
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
