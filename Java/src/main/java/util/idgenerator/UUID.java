package util.idgenerator;

/**
 * 生成32位16进制数
 * @ClassName UUID
 * @Description
 * @Author moku
 * @Date 2023/2/8 1:35
 * @Version 1.0
 */
public class UUID {
    public UUID() {
    }

    public static String getId() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}