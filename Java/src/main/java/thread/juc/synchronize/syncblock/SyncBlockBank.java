package thread.juc.synchronize.syncblock;

import java.util.Arrays;
import java.util.Vector;

/**
 * synchronized关键字：每个对象都有一个内部锁
 *                    方法用synchronized声明，则对象的锁将保护整个方法
 * 局限性：1. 不能中断一个正在试图获得锁的线程
 *        2. 试图获得锁时不能设定超时
 *        3. 每个锁仅有单一的条件 -> 业务可能不满足
 * @author moku
 */
public class SyncBlockBank {

    public double[] getAccounts() {
        return accounts;
    }

    // 处理器与编译器的内部处理机制导致不使用final可能导致各个线程的初始化值不一致
    // 即处理器能暂时在寄存器或本地内存缓冲区保存内存中的值。-> 不同处理器上的线程可能在同一位置取到不同值
    private final double[] accounts;
    // 用于使每个Java对象持有锁
    private Object obj = new Object();

    public SyncBlockBank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * synchronized(obj)：同步阻塞
     * wait：线程等待(直到条件满足，即notifyAll();)
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {

        // 同步阻塞
        synchronized (obj) {
            while (accounts[from] < amount) {
                System.out.printf(Thread.currentThread() + "*** wait***：Transfer [%10.2f] from account[%d:%10.2f] to account[%d:%10.2f].", amount, from, accounts[from], to, accounts[to]);
                System.out.println();
                // 同步阻塞：释放synchronized锁，进入等待状态
                obj.wait();
            }
            System.out.print(Thread.currentThread() + ":");
            accounts[from] -= amount;
            System.out.printf("Transfer [%10.2f] from account[%d:%10.2f] to account[%d].", amount, from, accounts[from], to);
            accounts[to] += amount;
            System.out.printf("After transfer, total balance:%10.2f%n", getTotalBalance());
            // 解除等待线程的阻塞状态
            obj.notifyAll();
            System.out.println(Thread.currentThread() + ":lock release.");
        }
    }

    /**
     * 客户端锁定client-side locking：使用对象锁来实现额外的原子操作
     * @param accounts
     * @param from
     * @param to
     * @param amount
     */
    public void transfer2(Vector<Double> accounts, int from, int to, double amount) {
        // 截获锁
        // 无法确保Vector类对自己的所有修改方法都使用内部锁
        synchronized (accounts) {
            accounts.set(from, accounts.get(from) - amount);
            accounts.set(to, accounts.get(to) + amount);
        }
    }

    public double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
