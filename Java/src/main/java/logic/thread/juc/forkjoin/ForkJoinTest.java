package logic.thread.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @ClassName ForkJoinTest
 * @Description 计算和对比
 * @Author moku
 * @Date 2022/12/14 23:20
 * @Version 1.0
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. 传统计算方法：速度最慢
        normalCalculate();

        // 2. Forkjoin：速度其次
//        forkJoinCalculate();

        // Stream流并行：速度最快
        streamCalculate();
    }

    private static void streamCalculate() {
        long start = System.currentTimeMillis();
        // stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + ",时间：" + (end - start));
    }

    private static void forkJoinCalculate() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinTask task = new ForkJoinBase(0L, 10_0000_0000L);
        ForkJoinTask<Long> fjt = fjp.submit(task);
        Long sum = fjt.get();
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + ",时间：" + (end - start));
    }

    private static void normalCalculate() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + ",时间：" + (end - start));
    }
}
