package thread.multithread.reentrantlock;

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
public class ReentrantLockConditionBase {
    public static void main(String[] args) {


    }
}

/**
 * 生产者消费者模式(完成加1减一各一次操作)
 *
 */
class SupplierConsumer {
    public int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (number != 0) {
                // 当number有值时(即做过一次increase)，不再继续执行后面的增加处理，使当前线程等待
                condition.await();
            }
            number++;
            System.out.println(">>" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number--;
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
