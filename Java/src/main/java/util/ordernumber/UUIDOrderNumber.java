package util.ordernumber;

import util.ordernumber.utils.UUIDUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UUIDOrderNumber
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:03
 * @Version 1.0
 */
public class UUIDOrderNumber {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            String uuid = UUIDUtils.getId();
            System.out.println("uuid---" + (i + 1) + "=======" + uuid);
            set.add(uuid);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }
}
