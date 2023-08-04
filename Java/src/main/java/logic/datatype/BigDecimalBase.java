package logic.datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @ClassName BigDecimalBase
 * @Description BigDecimal：堆内存对象，效率低，内存占用大
 *              double/float：原始类型，线程私有栈中，效率高，内存占用相对较小
 * @Author moku
 * @Date 2022/12/19 0:29
 * @Version 1.0
 */
public class BigDecimalBase {

    public static void main(String[] args) {
        // 1. 浮点型数据应使用String类型构造器或者BigDecimal.valueOf构造器
        BigDecimal a = new BigDecimal("1.01");
        BigDecimal b = new BigDecimal("1.02");
        // BigDecimal是不可变类(Immutable)，即运算会产生新对象，并不改变原对象的指向
        System.out.println("String构造器精度不丢失：" + a.add(b));
        System.out.println("String构造器后a：" + a);

        // BigDecimal精度丢失：入参时精度就已经丢失，跟BigDecimal无关
        //                   入参的数据类型为浮点数，二进制无法精确表示浮点数，只能无限接近
        BigDecimal a1 = new BigDecimal(1.01);
        BigDecimal b1 = new BigDecimal(1.02);
        System.out.println("精度丢失：" + a1.add(b1));
        System.out.println("精度丢失后a1：" + a1);

        // BigDecimal.valueOf源码
//        public static BigDecimal valueOf(double val) {
//            return new BigDecimal(Double.toString(val));
//        }
        BigDecimal a11 = BigDecimal.valueOf(1.01);
        System.out.println("精度不丢失a11：" + a11);

        // 2. BigDecimal浮点数类型比较：应使用compareTo方法
        // 比较：变量c、d精度不同
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.010");
        // 精度不同：false
        System.out.println("BigDecimal数据比较(equal)：" + c.equals(d));
        // true
        System.out.println("BigDecimal数据比较(compareTo)：" + c.compareTo(d));

        // 3. 精度设置：运算时，应明确指定精度和舍入模式
        BigDecimal e = new BigDecimal("1.0");
        BigDecimal f = new BigDecimal("3.0");
        System.out.println("设置精度：" + e.divide(f,2, RoundingMode.HALF_UP));

        // 4. 字符串转换
//        BigDecimal g = new BigDecimal("35634535255456719.22345634534124578902");
        BigDecimal g = BigDecimal.valueOf(35634535255456719.22345634534124578902);
        System.out.println("默认科学计数法：" + g);
        System.out.println("不使用科学计数法：" + g.toPlainString());
        System.out.println("使用科学计数法：" + g.toString());
        System.out.println("使用工程计数法：" + g.toEngineeringString());

        // 4.2 可用NumberFormat类进行转换
        // 建立货币格式化引用
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // 设置小数点位数
        currency.setMaximumFractionDigits(64);
        // 建立百分比格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();
        // 设置百分比小数点位数：最多3位
        percent.setMaximumFractionDigits(3);

        // 金额
        BigDecimal loanAmount = new BigDecimal("15000.48");
        // 利率
        BigDecimal interestRate = new BigDecimal("0.0081234");
        // 相乘
        BigDecimal interest = loanAmount.multiply(interestRate);

        System.out.println("金额\t" + currency.format(loanAmount));
        System.out.println("利率\t" + percent.format(interestRate));
        System.out.println("利息\t" + currency.format(interest));

        // 5. 精度
        BigDecimal h = new BigDecimal("123.4500");
        BigDecimal i = new BigDecimal("123.45");
        BigDecimal j = new BigDecimal("1234500");
        // 4
        System.out.println("h小数位:" + h.scale());
        // 2
        System.out.println("i小数位:" + i.scale());
        // 0
        System.out.println("j小数位:" + j.scale());
        // 去掉末尾0：整数类型末尾0也会被删除
        // 2
        System.out.println("h去掉尾部0后小数位:" + h.stripTrailingZeros().scale());
        // 2
        System.out.println("i去掉尾部0后小数位:" + i.stripTrailingZeros().scale());
        // -2：表示该数据为整形且末尾包含2个0
        System.out.println("j去掉尾部0后小数位:" + j.stripTrailingZeros().scale());

        // 设置精度

        // 除法模式
        // RoundingMode.ROUND_UP:向远离0的方向舍入
        // 例：1.1 -> 2
        //    1.5 -> 2
        //    1.8 -> 2
        //    -1.1 -> -2
        //    -1.5 -> -2
        //    -1.8 -> -2
        // RoundingMode.ROUND_DOWN:向0方向舍入
        // 例：1.1 -> 1
        //    1.5 -> 1
        //    1.8 -> 1
        //    -1.1 -> -1
        //    -1.5 -> -1
        //    -1.8 -> -1
        // RoundingMode.ROUND_CEILING:向正无穷大方向舍入
        // 例：1.1 -> 2
        //    1.5 -> 2
        //    1.8 -> 2
        //    -1.1 -> -1
        //    -1.5 -> -1
        //    -1.8 -> -1
        // RoundingMode.ROUND_FLOOR:向负无穷大方向舍入
        // 例：1.1 -> 1
        //    1.5 -> 1
        //    1.8 -> 1
        //    -1.1 -> -2
        //    -1.5 -> -2
        //    -1.8 -> -2
        // RoundingMode.ROUND_HALF_UP:以5为分界线，四舍五入
        // 例：1.1 -> 1
        //    1.5 -> 2
        //    1.8 -> 2
        //    -1.1 -> -1
        //    -1.5 -> -1
        //    -1.8 -> -1
        // RoundingMode.ROUND_HALF_DOWN:以5为分界线，五舍六入
        // 例：1.1 -> 1
        //    1.5 -> 1
        //    1.8 -> 2
        //    -1.1 -> -1
        //    -1.5 -> -1
        //    -1.8 -> 0 ?
        // RoundingMode.ROUND_HALF_EVEN:以5为分界线，偶数舍入
        // 例：1.1 -> 1
        //    1.5 -> 2
        //    1.8 -> 2
        //    -1.1 -> -1
        //    -1.5 -> -1
        //    -1.8 -> -1
        // RoundingMode.ROUND_UNNECESSARY:断言所请求的操作具有精确的结果，因此不需要舍入。否则将抛出{@link ArithmeticException}异常

        // 商和余数
        BigDecimal k = new BigDecimal("12.75");
        BigDecimal l = new BigDecimal("0.15");
        System.out.println("k商:" + k.divideAndRemainder(l)[0]);
        System.out.println("k余数:" + k.divideAndRemainder(l)[1]);

        // 6. 比较大小
        BigDecimal m = new BigDecimal("12.75");
        BigDecimal n = new BigDecimal("0.15");
        System.out.println("m大于n:" + (m.compareTo(n) > 0));
        System.out.println("m小于n:" + (m.compareTo(n) < 0));
    }
}
