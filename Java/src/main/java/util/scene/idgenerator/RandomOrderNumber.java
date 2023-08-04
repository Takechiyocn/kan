package util.scene.idgenerator;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RandomOrderNumber
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:04
 * @Version 1.0
 */
public class RandomOrderNumber {
    public static void main(String[] args) {
        //时间（精确到毫秒）
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);
        //随机数
        String randomNumeric = RandomStringUtils.randomNumeric(8);

        long startTime = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
//        for(int i=0;i<10000000;i++){
            String orderNumber = localDate + randomNumeric;
            System.out.println("orderNumber---" + (i + 1) + "=======" + orderNumber);
            set.add(orderNumber);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }
}
