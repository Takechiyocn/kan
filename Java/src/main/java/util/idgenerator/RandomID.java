package util.idgenerator;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 获取随机数:系统时间(17位) + 随机数(默认8位)
 *
 * @ClassName RandomID
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:04
 * @Version 1.0
 */
public class RandomID {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
        for(int i=0;i<10000000;i++){
            String id = getId(0);
            System.out.println("id---" + (i + 1) + "=======" + id);
            set.add(id);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("set.size():" + set.size());
        System.out.println("endTime-startTime:" + (endTime - startTime));
    }

    /**
     * ID = 系统时间(17位) + 随机数(默认8位)
     * @Params:[]
     * @Returns:java.lang.String
     */
    public static String getId(int length) {
        // 时间（精确到毫秒）
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);

        if (length == 0) {
            // 默认随机数长度(8位)
            return localDate + RandomStringUtils.randomNumeric(8);
        } else {
            // 指定随机数长度
            return localDate + RandomStringUtils.randomNumeric(length);
        }
    }
}
