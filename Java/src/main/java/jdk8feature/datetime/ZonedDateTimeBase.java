package jdk8feature.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @ClassName ZonedDateTimeBase
 * @Description
 * @Author moku
 * @Date 2023/1/6 15:38
 * @Version 1.0
 */
public class ZonedDateTimeBase {

    public static void main(String args[]) {
        ZonedDateTimeBase java8tester = new ZonedDateTimeBase();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime() {

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
