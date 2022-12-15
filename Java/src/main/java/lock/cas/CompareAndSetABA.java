package lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CompareAndSetABA
 * @Description
 * @Author moku
 * @Date 2022/12/15 9:13
 * @Version 1.0
 */
public class CompareAndSetABA {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(2020);
        //捣乱的线程
        System.out.println(ai.compareAndSet(2020,2021));
        System.out.println(ai.get());
        System.out.println(ai.compareAndSet(2021,2020));
        System.out.println(ai.get());
        //期望的线程(不关心中间过程，只关心初始值和最终值)
        System.out.println(ai.compareAndSet(2020,2021));
        System.out.println(ai.get());
    }
}
