package jdk8feature;

import interfacecustomize.Calculator;

/**
 * @author moku
 */
public class LambdaCalculator {
    public static void main(String[] args) {
        LambdaCalculator test = new LambdaCalculator();
        System.out.println(test.add(1,2));
        System.out.println(test.minus(5,1));
        System.out.println(test.multi(5,2));
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
        return operator(v1, v2, Integer::sum);
    }

    public Integer minus(Integer v1, Integer v2) {
        System.out.print("进行减法运算：");
        return operator(v1, v2, (x, y) -> x - y);
    }

    public Integer multi(Integer v1, Integer v2) {
        return operator(v1, v2, (x,y) -> x * y);
    }
}
