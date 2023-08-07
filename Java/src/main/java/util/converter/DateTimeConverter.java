package util.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Date Time Transfer Utils
 * @Params:
 * @Returns:
 */
public class DateTimeConverter {

    public static void main(String[] args) {
        // date -> localDateTime
        System.out.println("Date to LocalDateTime: " + transferDateToLocalDateTime(new Date()));
        // localDateTime -> date
        System.out.println("LocalDateTime to Date: " + transferLocalDateTimeToDate(LocalDateTime.now()));
    }

    /**
     * Date to LocalDateTime
     * @Params:[date]
     * @Returns:java.time.LocalDateTime
     */
    public static LocalDateTime transferDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = instant.atZone(zoneId);
        return zdt.toLocalDateTime();
    }

    /**
     * LocalDateTime to Date
     * @Params:[localDateTime]
     * @Returns:java.util.Date
     */
    public static Date transferLocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Instant instant = zdt.toInstant();
        return Date.from(instant);
    }
}
