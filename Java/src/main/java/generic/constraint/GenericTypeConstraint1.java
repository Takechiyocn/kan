package generic.constraint;

import generic.GenericTypeCommon;

/**
 * @ClassName GenericTypeConstraint1
 * @Description 约束与局限性1：
 *                 不能用基本类型实例化类型参数(泛型类型变量)，即泛型类型变量不能为基本类型
 *                 -> 类型擦除后，Object类型的域不能存储基本类型的值
 * @Author moku
 * @Date 2022/11/26 21:33
 * @Version 1.0
 */
public class GenericTypeConstraint1 {
    public static void confirm() {
        // 调用时包含参数[1]:3.14、参数[3]:(double)0的Double装箱过程
        // 返回时包含Double的拆箱过程
        double d = GenericTypeCommon.<Double>getMiddle(3.14, Double.valueOf(172), (double) 0);
        // 调用时包含Integer装箱过程
        // 返回时包含Integer的拆箱过程
        int n = GenericTypeCommon.<Integer>getMiddle(10, 15, 31);
        System.out.println("约束与局限性1：不能用基本类型实例化类型参数[" + d + "]");
        System.out.println("约束与局限性1：不能用基本类型实例化类型参数[" + n + "]");
    }
}
