package thread.juc.synchronize;

/**
 * @ClassName SynchronizedBase
 * @Description 生产者消费者
 * @Author moku
 * @Date 2022/12/13 23:09
 * @Version 1.0
 */
public class SynchronizedBase {
    public static void main(String[] args) {

        SupplierConsumer sc = new SupplierConsumer();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sc.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread D").start();
    }
}

/**
 * 生产者消费者模式(完成加1减一各一次操作)
 *
 */
class SupplierConsumer {
    public int number = 0;

    public synchronized void increase() throws InterruptedException {
        // if产生虚假唤醒
//        if (number != 0) {
        while (number != 0) {
            // 当number有值时(即做过一次increase)，不再继续执行后面的增加处理，使当前线程等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + ">>" + number);
        // 通知其他线程我+1完成
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        // if产生虚假唤醒
//        if (number != 1) {
        while (number != 1) {
            // 当number没有值时(即做过一次decrease)，不再继续执行后面的减少处理，使当前线程等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ">>" + number);
        // 通知其他线程我-1完成
        this.notifyAll();
    }
}
