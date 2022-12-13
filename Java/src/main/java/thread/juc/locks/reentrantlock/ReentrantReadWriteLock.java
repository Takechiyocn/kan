package thread.juc.locks.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @ClassName ReentrantReadWriteLock
 * @Description
 * @Author moku
 * @Date 2022/12/13 12:44
 * @Version 1.0
 */
public class ReentrantReadWriteLock {
    public static void main(String[] args) {

        MyCacheLock mycache = new MyCacheLock();
//        MyCache mycache = new MyCache();

        // 写入操作
        for (int i = 0; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                mycache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        // 读取操作
        for(int i = 0; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                mycache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁
    private ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    public Object get(String key) {
        lock.readLock().lock();
        Object o = null;
        try {
            System.out.println(Thread.currentThread().getName() + "读取开始");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK:" + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return o;
    }

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入开始: key=" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    public Object get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取");

        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK:" + o);

        return o;
    }

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入:key=" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

}
