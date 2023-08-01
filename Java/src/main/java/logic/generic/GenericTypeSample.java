package logic.generic;

import java.time.LocalDate;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/10 0:30
 */
public class GenericTypeSample {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        // 泛型实现String对比
        // mm类型：GenericTypeCommon
        GenericTypeCommon<String> mm = GenericTypeCommon.minmax(words);
        System.out.println("string min=" + mm.getFirst());
        System.out.println("string max=" + mm.getSecond());

        // 泛型实现Integer对比
        Integer[] integer = {12, 34, 56};
        GenericTypeCommon<Integer> minInteger = GenericTypeCommon.minmax(integer);
        System.out.println("integer min=" + minInteger.getFirst());
        System.out.println("integer max=" + minInteger.getSecond());

        // 泛型实现LocalDate对比
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22),
        };
        GenericTypeCommon<LocalDate> localDatePair = GenericTypeCommon.minmax(birthdays);
        System.out.println("localDate min=" + localDatePair.getFirst());
        System.out.println("localDate max=" + localDatePair.getSecond());

        // <String>可被编译器推断出，可省略
//        String ms = GenericTypeCommon.<String>getMiddle(words);
        String ms = GenericTypeCommon.getMiddle(words);
        System.out.println("middle of string=" + ms);

        // 基本类型的包装类型实例化类型参数
        // 调用时：装箱
        // 返回时：拆箱
        double mi = GenericTypeCommon.<Double>getMiddle(3.14, 172.0, (double) 0);
        System.out.println("middle of double=" + mi);

        // 泛型类型变量与返回值类型不一致
        GenericTypeCommon.<Double>voidReturnType(3.14, 172.0, (double) 0);
    }
}
