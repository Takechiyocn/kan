package util.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * DateTime Converter Utils
 *
 * @author moku
 * @date 2023/8/8 22:48:01
 * @version 1.0
 */
public class DateTimeConverter {

    public static void main(String[] args) {
        // date -> localDateTime
        System.out.println("Date to LocalDateTime: " + dateToLocalDateTime(new Date()));
        // localDateTime -> date
        System.out.println("LocalDateTime to Date: " + localDateTimeToDate(LocalDateTime.now()));
    }

    /**
     * Date to LocalDateTime
     *
     * @param date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = instant.atZone(zoneId);
        return zdt.toLocalDateTime();
    }

    /**
     * LocalDateTime to Date
     *
     * @param localDateTime
     * @return java.util.Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Instant instant = zdt.toInstant();
        return Date.from(instant);
    }
}
