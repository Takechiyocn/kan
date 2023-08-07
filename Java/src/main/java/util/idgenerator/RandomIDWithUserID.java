package util.idgenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * 获取随机数:系统时间(17位) + 用户ID(指定长度) + 随机数(默认8位)
 * @ClassName RandomIDWithUserID
 * @Description
 * @Author moku
 * @Date 2023/2/8 2:09
 * @Version 1.0
 */
public class RandomIDWithUserID {

    /**
     * ID = 系统时间(17位) + 用户ID(指定长度) + 随机数(默认8位)
     * @Params:[userId, userIdLen, randomNumericLen]
     * @Returns:java.lang.String
     */
    public static synchronized String getId(@NotNull Object userId, int userIdLen, int randomNumericLen) {
        // 时间（精确到毫秒）
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);

        // 随机数
        String randomNumeric;
        if (randomNumericLen == 0) {
            // 默认随机数:8位
            randomNumeric = RandomStringUtils.randomNumeric(8);
        } else {
            // 指定长度随机数
            randomNumeric = RandomStringUtils.randomNumeric(randomNumericLen);
        }

        // 用户ID
        String sUserId;
        if (!(userId instanceof String)) {
            sUserId = userId.toString();
        } else {
            sUserId = (String) userId;
        }

        // 用户ID长度
        int idLen = sUserId.length();
        String str;
        if (idLen >= userIdLen) {
            str = sUserId.substring(idLen - userIdLen, idLen);
        } else {
            str = String.format("%0" + userIdLen + "d", userId);
        }

        return localDate + str + randomNumeric;
    }
}
