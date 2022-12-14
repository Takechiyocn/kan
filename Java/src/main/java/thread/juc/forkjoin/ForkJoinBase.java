package thread.juc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName ForkJoinBase
 * @Description
 * @Author moku
 * @Date 2022/12/14 23:09
 * @Version 1.0
 */
public class ForkJoinBase extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    // 临界值
    private Long temp = 10000L;

    public ForkJoinBase(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    // 计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            int sum = 0;
            for (int i = 1; i < 10_0000_0000; i++) {
                sum += i;
            }
            return Long.valueOf(sum);
        } else {
            Long middle = (start + end) / 2;
            ForkJoinBase fj1 = new ForkJoinBase(start, middle);
            //拆分任务，把任务压到线程队列
            fj1.fork();
            ForkJoinBase fj2 = new ForkJoinBase(middle+1, end);
            //拆分任务，把任务压到线程队列
            fj2.fork();
            return fj1.join() + fj2.join();
        }
    }
}
