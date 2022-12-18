package util;

import java.util.UUID;

/**
 * @ClassName UUIDBase
 * @Description 唯一标识码
 *                1. 生成标识码：随机
 *                2. 生成标识码：从指定字符串
 *                3. 生成标识码：从指定byte数组
 * @Author moku
 * @Date 2022/12/4 0:56
 * @Version 1.0
 */
public class UUIDBase {
    public static void main(String[] args) {

        // 1. 生成标识码：随机
        UUID uid = UUID.randomUUID();
        System.out.println(uid);

        // 2. 生成标识码：从指定字符串
        UUID uid2 = UUID.fromString("37fd600a-71e2-4b15-8fc4-4881e48a4979");
        System.out.println(uid2);


        // 3. 生成标识码：从指定byte数组
        byte[] b = {2, 3};
        UUID uid3 = UUID.nameUUIDFromBytes(b);
        System.out.println(uid3);

        // 获取UUID的String对象
        System.out.println(uid3.toString());
        System.out.println(uid3.toString().substring(0, 5));
    }
}
