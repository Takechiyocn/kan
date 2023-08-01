package logic.lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CompareAndSetBase
 * @Description
 * @Author moku
 * @Date 2022/12/15 9:03
 * @Version 1.0
 */
public class CompareAndSetBase {
    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(2020);
        // compareAndSet, exceptValue:期望值，newValue:更新值
        // 期望值达到了则更新(返回true)，否不不更新(返回false)
        System.out.println(ai.compareAndSet(2020, 2021));
        System.out.println("更新后，ai=" + ai.get());
        // ai++
        ai.getAndIncrement();
        // ai=2022，以下不更新，返回false
        System.out.println(ai.compareAndSet(2020, 2025));
        System.out.println("不更新，ai=" + ai.get());
    }
}
