package multithread;

/**
 * volatile关键字：变量可见性，禁止指令重排
 *                一种免锁同步访问机制，volatile变量直接从主存读写最新值
 *                -> 不保证原子性
 * 原子atomic操作：不可分割的操作，即不会因为线程调度被打断的操作
 * @author moku
 */
public class VolatileBase {

    private volatile boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }

    // volatile变量不能提供原子性：不能确保翻转域(下述done = !done)中的值，即不能保证读取、翻转和写入不被中断
    public void flipDone() {
        done = !done;
    }

    public void atomicSample() {

        // 原子操作
        int m;
        // 原子操作：要么执行成功m赋值为6，要么没执行m还是0。即不会出现m=3这种中间状态
        m = 6;

        // 非原子操作：1. 声明变量为n -> 中间态
        //           2. 给n赋值6
        int n = 6;
    }
}
