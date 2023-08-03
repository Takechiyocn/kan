package util.ordernumber;

import org.apache.commons.lang3.RandomStringUtils;

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
     * 生成订单号（25位）：时间（精确到毫秒）+3位随机数+5位用户id
     */
    public static synchronized  String getOrderNum(Long userId) {
        //时间（精确到毫秒）
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);
        //3位随机数
        String randomNumeric = RandomStringUtils.randomNumeric(3);
        //5位用户id
        int subStrLength = 5;
        String sUserId = userId.toString();
        int length = sUserId.length();
        String str;
        if (length >= subStrLength) {
            str = sUserId.substring(length - subStrLength, length);
        } else {
            str = String.format("%0" + subStrLength + "d", userId);
        }
        String orderNum = localDate + randomNumeric + str;
        System.out.println("订单号:" + orderNum);
        ;
        return orderNum;
    }
}
