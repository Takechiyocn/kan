package designstructure.behavior.b3interpreter;

import designstructure.behavior.b3interpreter.interpreter.Expression;
import designstructure.behavior.b3interpreter.interpreter.OperatorInterpreter;

/**
 * @ClassName Add
 * @Description
 * @Author moku
 * @Date 2022/12/25 0:58
 * @Version 1.0
 */
public class Add extends OperatorInterpreter {

    Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
