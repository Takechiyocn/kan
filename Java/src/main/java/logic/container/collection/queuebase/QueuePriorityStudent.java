package logic.container.collection.queuebase;

import java.util.List;

/**
 * @ClassName QueuePriorityStudent
 * @Description TODO
 * @Author moku
 * @Date 2022/11/24 1:49
 * @Version 1.0
 */
public class QueuePriorityStudent {

    // 姓名
    public String name;
    // 分数
    public List<Integer> score;

    public QueuePriorityStudent(String name, List<Integer> score) {
        this.name = name;
        this.score = score;
    }

    public QueuePriorityStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        int avg = score.stream().reduce(0, Integer::sum) / score.size();
        return "name:" + name + ",score:" + score + "，平均分：" + avg;
    }
}
