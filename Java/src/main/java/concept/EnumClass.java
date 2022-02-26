package concept;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @description: 所有的枚举类型都继承自Enum
 * @author: Kan
 * @date: 2021/2/23 22:44
 */
@Slf4j
public class EnumClass {
    public static void main(String[] args) {
        // 声明枚举常量1：使用枚举实例
        // 枚举常量实际为实例
        Size enumP = Size.SMALL;
        log.info("声明枚举常量1，使用枚举实例:" + enumP.toString());

        // 声明枚举常量2: Enum.valueOf
        // 所有的枚举类型继承自enum
        Size enumP2 = Enum.valueOf(Size.class, "LARGE");
        log.info("声明枚举常量2，使用超类Enum:" + enumP2.toString());

        // 声明枚举常量3: Size.valueOf
        // 所有的枚举类型继承自enum
        Size enumP3 = Size.valueOf("EXTRA_BIG");
        log.info("声明枚举常量3，使用定义Size:" + enumP3.toString() + enumP3.getCnAbbreviation());

        // 声明枚举常量数组1: values（返回包含所有枚举值的数组）
        Size[] enumP4 = Size.values();
        for (Size size : enumP4) {
            log.info("声明枚举常量数组1，使用定义values:" + size.toString() + size.getCnAbbreviation());
        }

        // ordinal：枚举常量在enum声明中的位置，从0开始
        log.info("枚举常量定义位置ordinal:" + Size.MEDIUM.ordinal());

        // 声明枚举常量数组2:
        // compareTo：果枚举常量出现在other之前，则返回一个负值；
        //            如果this==other，则返回0；否则，返回正值。
        //            枚举常量的出现次序在enum声明中给出。
        Size[] enumP5 = new Size[]{Size.MEDIUM, Size.LARGE};
        for (Size size : enumP5) {
            // 实际实现不为构造器，枚举类型构造器(protected)只能编译器内部使用
            log.info("声明枚举常量数组2，使用构造器new Size[]{}:" + size.toString() + size.getCnAbbreviation());
        }
        log.info("枚举常量比较:" + enumP5[0].compareTo(enumP5[1]));

        // Scanner
        Scanner in = new Scanner(System.in);
        log.warn("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        log.info("Chosen:" + size.toString() + ",abbreviation:" + size.getAbbreviation());
    }

    /**
     * 枚举类型实际上定义一个类，即枚举类型和类类型类似
     * 枚举常量为实例
     */
    public enum Size {
        /**
         *
         */
        SMALL("S", "小"),
        MEDIUM("M", "中"),
        LARGE("L", "大"),
        EXTRA_BIG("XL", "超大");

        private final String abbreviation;
        private final String cnAbbreviation;

        /**
         * 私有构造函数：SMALL等均为Size枚举类型
         * 即SMALL(abbreviation, cnAbbreviation)等
         *
         * @param abbreviation:
         * @param cnAbbreviation:
         */
        private Size(String abbreviation, String cnAbbreviation) {
            this.abbreviation = abbreviation;
            this.cnAbbreviation = cnAbbreviation;
        }

        public String getAbbreviation() {
            return this.abbreviation;
        }

        public String getCnAbbreviation() {
            return this.cnAbbreviation;
        }
    }
}
