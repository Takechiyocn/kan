package logic.test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Test
 * @Description
 * @Author moku
 * @Date 2023/2/4 21:57
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        String str = "12a6B985Ccv65";
        String regex = "[a-zA-Z]+";
        String regex2 = "[\\d]+";

        System.out.println(str.replaceAll(regex,"&"));
        System.out.println(str.replaceAll(regex2,"0"));
        String str2 = "boo:and:foo";
        String regex3 = "[o]+";
        String[] arr = str2.split(regex3);
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
