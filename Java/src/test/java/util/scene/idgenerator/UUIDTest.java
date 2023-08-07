package util.scene.idgenerator;

import util.idgenerator.UUID;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UUIDTest
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:03
 * @Version 1.0
 */
public class UUIDTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            String uuid = UUID.getId();
            System.out.println("uuid---" + (i + 1) + "=======" + uuid);
            set.add(uuid);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }
}
