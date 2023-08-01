package logic.lock.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName CompareAndSAetABAResolve
 * @Description ABA漏洞解决
 * @Author moku
 * @Date 2022/12/15 9:33
 * @Version 1.0
 */
public class CompareAndSAetABAResolve {
    public static void main(String[] args) {

        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(1, 1);
        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println("A1==>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A2 cas:" +
                    asr.compareAndSet(1, 2, asr.getStamp(), asr.getStamp() + 1));
            System.out.println("A2 Stamp==>" + asr.getStamp());
            System.out.println("A3 cas:" +
                    asr.compareAndSet(2, 1, asr.getStamp(), asr.getStamp() + 1));
            System.out.println("A3 Stamp==>" + asr.getStamp());
        }, "线程A").start();
        new Thread(() -> {
            int stamp = asr.getStamp();//获得版本号
            System.out.println("B1==>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B2 cas:" +
                    asr.compareAndSet(1, 4, stamp, stamp + 1));
            System.out.println("B2==>" + asr.getStamp());
        }, "线程B").start();
    }
}
