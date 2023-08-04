package logic.container.collection.queuebase;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName QueuePrioritySample
 * @Description TODO
 * @Author moku
 * @Date 2022/11/24 1:47
 * @Version 1.0
 */
public class QueuePrioritySample {

    public static void main(String[] args) {
        QueuePriorityStudent student1 = new QueuePriorityStudent("小明", Arrays.asList(77, 56, 98));
        QueuePriorityStudent student2 = new QueuePriorityStudent("小王", Arrays.asList(95, 62, 80));
        QueuePriorityStudent student3 = new QueuePriorityStudent("小红", Arrays.asList(82, 69, 73));
        QueuePriorityStudent student4 = new QueuePriorityStudent("小刘", Arrays.asList(90, 86, 74));

        Queue<QueuePriorityStudent> q = new PriorityQueue<>((a, b) -> {
            //计算每个学生分数的平均分，降序排序（即平均分越高优先级越高，越先出队列）
            List<Integer> lisaA = a.getScore();
            List<Integer> lisaB = b.getScore();
            int avgA = lisaA.stream().reduce(0, Integer::sum) / lisaA.size();
            int avgB = lisaB.stream().reduce(0, Integer::sum) / lisaB.size();
            return avgB - avgA;
        });

        q.offer(student1);
        q.offer(student2);
        q.offer(student3);
        q.offer(student4);
        System.out.println(q);

        while (!q.isEmpty()) {
            System.out.println(q.poll().toString());
        }
    }
}
