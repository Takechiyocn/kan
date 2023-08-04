package util.converter;

import java.util.Objects;

/**
 * @ClassName IntegerConverter
 * @Description
 * @Author moku
 * @Date 2023/7/21 22:09
 * @Version 1.0
 */
public class IntegerConverter {
    public static Integer valueOf(String value) {
        return Integer.valueOf(Objects.requireNonNullElse(value, "0"));
    }
}
