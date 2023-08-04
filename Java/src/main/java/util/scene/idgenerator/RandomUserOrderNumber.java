package util.scene.idgenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName RandomUserOrderNumber
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:09
 * @Version 1.0
 */
public class RandomUserOrderNumber {

    /**
     * 生成ID：时间（精确到毫秒）+ 指定随机数长度 + 指定用户id长度
     * @Params:[userId, userIdLen, randomNumberLen]
     * @Returns:java.lang.String
     */
    public static synchronized String getId(@NotNull Object userId, @NotNull int userIdLen, @NotNull int randomNumberLen) {
        // 时间（精确到毫秒）
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);

        // 指定长度随机数
        String randomNumeric = RandomStringUtils.randomNumeric(randomNumberLen);

        // 指定长度用户ID
        String sUserId;
        if (!(userId instanceof String)) {
            sUserId = userId.toString();
        } else {
            sUserId = (String) userId;
        }
        int length = sUserId.length();
        String str;
        if (length >= userIdLen) {
            str = sUserId.substring(length - userIdLen, length);
        } else {
            str = String.format("%0" + userIdLen + "d", userId);
        }

        // ID = 时间（精确到毫秒总计17位）+ 指定随机数长度 + 指定用户id长度
        return localDate + randomNumeric + str;
    }
}
