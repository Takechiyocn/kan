package logic.thread.juc.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName SafeSetInJUCCollections
 * @Description Set不安全，解决方式：
 *              1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
 *              2. Set<String> set = new CopyOnWriteArraySet<>(new HashSet<>());
 * @Author moku
 * @Date 2022/12/4 1:56
 * @Version 1.0
 */
public class SafeSetInJUCCollections {

    public static void main(String[] args) {

        // 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
        synchronizedSet();

        // 2. Set<String> set = new CopyOnWriteArraySet<>(new HashSet<>());
        copyOnWriteArraySet();
    }

    private static void copyOnWriteArraySet() {
        Set<String> set = new CopyOnWriteArraySet<>(new HashSet<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void synchronizedSet() {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
