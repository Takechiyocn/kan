package util.scene.idgenerator.utils;

/**
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
        String id = java.util.UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}