package util.wrapper;

import java.math.BigDecimal;

/**
 * @ClassName BigDecimalWrapper
 * @Description
 * @Author moku
 * @Date 2023/7/21 23:39
 * @Version 1.0
 */
public class BigDecimalWrapper {

    public static BigDecimal of(Object value) {
        return parse(value);

    }

    private static BigDecimal parse(Object value) {
        BigDecimal result = BigDecimal.ZERO;
        if (value instanceof BigDecimal) {
            result = (BigDecimal) value;
        } else if (value instanceof Integer) {
            result = new BigDecimal((Integer) value);
        }
        return result;
    }
}
