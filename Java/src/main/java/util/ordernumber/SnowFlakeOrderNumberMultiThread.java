package util.ordernumber;

import util.ordernumber.utils.SnowFlake;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName SnowFlakeOrderNumber
 * @Description 多线程测试
 * @Author moku
 * @Date 2023/2/8 2:14
 * @Version 1.0
 */
public class SnowFlakeOrderNumberMultiThread {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch=new CountDownLatch(10000000);
        final SnowFlake idWorker = new SnowFlake(0, 0);
        Set set = Collections.synchronizedSet(new HashSet());
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    long id = idWorker.nextId();
                    System.out.println("id:"+id);
                    set.add(id);
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }
}
