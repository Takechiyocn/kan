package util.ordernumber.utils;

import java.util.UUID;

/**
 * @ClassName UUIDUtils
 * @Description
 * @Author moku
 * @Date 2023/2/8 1:35
 * @Version 1.0
 */
public class UUIDUtils {
    public UUIDUtils() {
    }

    public static String getId() {
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}