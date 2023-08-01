package logic.designstructure.behavior.b3interpreter;

import logic.designstructure.behavior.b3interpreter.interpreter.Expression;
import logic.designstructure.behavior.b3interpreter.interpreter.NumberInterpreter;

import java.util.Stack;

/**
 * @ClassName Calculator
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:01
 * @Version 1.0
 */
public class Calculator {
    int calculate(String expression) {
        Stack<Expression> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char word = expression.charAt(i);
            switch (word) {
                case '加':
                    stack.push(new Add(stack.pop(), new NumberInterpreter(expression.charAt(++i))));
                    break;
                case '减':
                    stack.push(new Sub(stack.pop(), new NumberInterpreter(expression.charAt(++i))));
                    break;
                default:
                    stack.push(new NumberInterpreter(word));
                    break;
            }
        }
        return stack.pop().interpret();
    }
}
