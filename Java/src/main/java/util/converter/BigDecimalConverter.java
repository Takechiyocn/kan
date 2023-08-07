package util.converter;

import util.ComUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimalConverter
 *
 * @author moku
 * @date 2023/8/8 01:34:24
 * @version 1.0
 */
public class BigDecimalConverter {

    private static final int precision = 2;

    public static BigDecimal valueOf(Object value) {
        return parse(value);
    }

    /**
     * add
     * @param value1 
     * @param value2 
     * @return java.math.BigDecimal
     */
    public static BigDecimal add(Object value1, Object value2) {
        return parse(value1).add(parse(value2));
    }

    /**
     * subtract
     * @param value1 
     * @param value2 
     * @return java.math.BigDecimal
     */
    public static BigDecimal subtract(Object value1, Object value2) {
        return parse(value1).subtract(parse(value2));
    }

    /**
     * multiply
     * @param value1 
     * @param value2 
     * @return java.math.BigDecimal
     */
    public static BigDecimal multiply(Object value1, Object value2) {
        return parse(value1).multiply(parse(value2));
    }

    /**
     * divide
     * @param value1 
     * @param value2 
     * @param precision 
     * @param roundingMode 
     * @return java.math.BigDecimal
     */
    public static BigDecimal divide(Object value1, Object value2, int precision, RoundingMode roundingMode) {
        // 被除数为空或者0
        if (ComUtil.isEmpty(value2) || parse(value2).compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("value2 can not be null or zero");
        }

        // 除数为空
        if (ComUtil.isEmpty(value1)) {
            throw new IllegalArgumentException("value1 can not be null");
        }

        // 除数为0，直接返回0
        if (parse(value1).compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        // 自定义精度、小数位截取模式
        if (ComUtil.isNotEmpty(roundingMode)) {
            return parse(value1).divide(parse(value2), precision, roundingMode);
        }

        // 默认精度、小数位截取模式
        return parse(value1).divide(parse(value2), BigDecimalConverter.precision, RoundingMode.HALF_UP);
    }

    /**
     * valueOf
     * @param value 
     * @return java.math.BigDecimal
     */
    public static BigDecimal valueOf(Integer value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value);
    }

    /**
     * valueOf
     * @param value 
     * @return java.math.BigDecimal
     */
    public static BigDecimal valueOf(Long value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(value);
    }

    /**
     * valueOf
     * @param value 
     * @return java.math.BigDecimal
     */
    public static BigDecimal valueOf(Float value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(value.toString());
    }

    /**
     * valueOf
     * @param value 
     * @return java.math.BigDecimal
     */
    public static BigDecimal valueOf(Double value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        // 对于整形数据类型转换，不能使用new BigDecimal(value)进行转换(会有精度丢失)，
        // 应使用new BigDecimal(value.toString())或者BigDecimal.valueOf(value)进行转换
        return BigDecimal.valueOf(value);
    }

    /**
     * valueOf
     * @param value 
     * @return java.math.BigDecimal
     */
    public static BigDecimal valueOf(String value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(value);
    }

    /**
     * parse
     * @param value 
     * @return java.math.BigDecimal
     */
    private static BigDecimal parse(Object value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal result = BigDecimal.ZERO;
        if (value instanceof Integer) {
            result = valueOf((Integer) value);
        } else if (value instanceof Long) {
            result = valueOf((Long) value);
        } else if (value instanceof Float) {
            result = valueOf((Float) value);
        } else if (value instanceof Double) {
            result = valueOf((Double) value);
        } else if (value instanceof String) {
            result = valueOf((String) value);
        } else if (value instanceof BigDecimal) {
            result = (BigDecimal) value;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + value.getClass().getName());
        }

        return result;
    }
}
