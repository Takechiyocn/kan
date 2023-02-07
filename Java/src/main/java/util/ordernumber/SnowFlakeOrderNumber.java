package util.ordernumber;

import util.ordernumber.utils.SnowFlake;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName SnowFlakeOrderNumber
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:14
 * @Version 1.0
 */
public class SnowFlakeOrderNumber {

    /**
     * 测试
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SnowFlake idWorker = new SnowFlake(0, 0);
        Set set = new HashSet();
        for (int i = 0; i < 10000000; i++) {
            long id = idWorker.nextId();
            set.add(id);
            System.out.println("id----" + i + ":" + id);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }
}
