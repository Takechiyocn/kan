package designstructure.behavior.b3interpreter.interpreter;

/**
 * @ClassName OperatorInterpreter
 * @Description
 * @Author moku
 * @Date 2022/12/25 0:55
 * @Version 1.0
 */
public abstract class OperatorInterpreter implements Expression {
    public Expression left;
    public Expression right;

    public OperatorInterpreter(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
