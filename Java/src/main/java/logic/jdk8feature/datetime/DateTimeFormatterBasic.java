package logic.jdk8feature.datetime;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterBasic {

    public static void main(String[] args) {
        // formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // parse: String -> Date
        String dateStr = "2020-12-12 22:22:22 222";
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println(date.format(formatter2));

        // format: Date -> String
        LocalDateTime now = LocalDateTime.now();
        String dateFormat = now.format(formatter);
        System.out.println(dateFormat);
    }
}
