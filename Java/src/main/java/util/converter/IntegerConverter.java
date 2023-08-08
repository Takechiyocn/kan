package util.converter;

import java.util.Objects;

/**
 * IntegerConverter
 *
 * @author moku
 * @date 2023/8/8 22:51:10
 * @version 1.0
 */
public class IntegerConverter {

    /**
     * String to Integer
     *
     * @param value
     * @return java.lang.Integer
     */
    public static Integer valueOf(String value) {
        return Integer.valueOf(Objects.requireNonNullElse(value, "0"));
    }
}
