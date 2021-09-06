package jdk8feature;

import interfacecustomize.Calculator;

/**
 * @author moku
 */
public class LambdaCalculator {
    public static void main(String[] args) {
        LambdaCalculator test = new LambdaCalculator();
        System.out.println(test.add(1, 2));
        System.out.println(test.minus(5, 1));
        System.out.println(test.multi(5, 2));
    }

    /**
     * 自定义函数式接口
     *
     * @param v1
     * @param v2
     * @param calculator
     * @return
     */
    public Integer operator(Integer v1, Integer v2, Calculator<Integer> calculator) {
        return calculator.operation(v1, v2);
    }

    public Integer add(Integer v1, Integer v2) {
        // 语法格式3：lambda体内只有一条语句，且有返回值，return可省略
        return operator(v1, v2, Integer::sum);
    }

    public Integer minus(Integer v1, Integer v2) {
        // 语法格式4：有2个以上参数，且lambda体中有多条语句
        return operator(v1, v2, (Integer x, Integer y) -> {
            System.out.print("进行减法运算：");
            return (x - y);
        });
    }

    public Integer multi(Integer v1, Integer v2) {
        // 语法格式5：lambda表达式的数据类型可以省略不写（JVM编译器通过上下文可以推断出数据类型）
        return operator(v1, v2, (x, y) -> x * y);
    }
}
