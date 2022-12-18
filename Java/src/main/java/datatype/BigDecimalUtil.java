package datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName BigDecimalUtil
 * @Description
 * @Author moku
 * @Date 2022/12/19 1:03
 * @Version 1.0
 */
public class BigDecimalUtil {
    private BigDecimalUtil() {
    }

    // 加
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    // 减
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    // 乘
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    // 除
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        // 2:保留小数点后两位
        // ROUND_HALF_UP:四舍五入
        return b1.divide(b2, 2, RoundingMode.HALF_UP);
    }
}
