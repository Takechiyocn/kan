package logic.designstructure.behavior.b3interpreter;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:12
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        Calculator c = new Calculator();
        String exp1 = "一加一";
        String exp2 = "一加一加一";
        String exp3 = "二加五减三";
        String exp4 = "七减五加四减一";
        String exp5 = "九减五加三减一";
        System.out.println(exp1 + "等于" + c.calculate(exp1));
        System.out.println(exp2 + "等于" + c.calculate(exp2));
        System.out.println(exp3 + "等于" + c.calculate(exp3));
        System.out.println(exp4 + "等于" + c.calculate(exp4));
        System.out.println(exp5 + "等于" + c.calculate(exp5));
    }
}
