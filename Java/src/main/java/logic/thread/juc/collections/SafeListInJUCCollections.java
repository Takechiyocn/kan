package logic.thread.juc.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName SafeListInJUCCollections
 * @Description 并发List不安全，可通过以下方式解决
 *                1. 使用Vector
 *                2. List<String> l = Collections.synchronizedList(new ArrayList());
 *                3. List<String> l = new CopyOnWriteArrayList<>();
 * @Author moku
 * @Date 2022/12/4 0:31
 * @Version 1.0
 */
public class SafeListInJUCCollections {
    public static void main(String[] args) {

        // 传统List多线程读写问题：CPU速度太快，导致读写混乱(读固定，写时可能覆盖)
//        listInMultiThread();

        // 1. 使用Vector
//        vectorOnArray();

        // 2. List<String> l = Collections.synchronizedList(new ArrayList());
//        synchronizedList();

        // 3. List<String> l = new CopyOnWriteArrayList<>();
        // 读写分离(读/写时不同容器)
        copyOnWriteArrayList();
    }

    private static void copyOnWriteArrayList() {
        List<String> l = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                l.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(l);
            }, String.valueOf(i)).start();
        }
    }

    private static void synchronizedList() {
        List<String> l = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                l.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(l);
            }, String.valueOf(i)).start();
        }
    }

    private static void vectorOnArray() {
        List<String> l = new Vector<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                l.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(l);
            }, String.valueOf(i)).start();
        }
    }

    private static void listInMultiThread() {
        // 异常：java.util.ConcurrentModificationException
        List<String> l = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                l.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(l);
            }, String.valueOf(i)).start();
        }
    }
}
