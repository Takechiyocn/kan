package logic.designstructure.behavior.b3interpreter.interpreter;

/**
 * @ClassName NumberInterpreter
 * @Description 数字解释器
 * @Author moku
 * @Date 2022/12/25 0:52
 * @Version 1.0
 */
public class NumberInterpreter implements Expression {
    int number;

    public NumberInterpreter(char word) {
        switch (word) {
            case '零':
                number = 0;
                break;
            case '一':
                number = 1;
                break;
            case '二':
                number = 2;
                break;
            case '三':
                number = 3;
                break;
            case '四':
                number = 4;
                break;
            case '五':
                number = 5;
                break;
            case '六':
                number = 6;
                break;
            case '七':
                number = 7;
                break;
            case '八':
                number = 8;
                break;
            case '九':
                number = 9;
                break;
            default:
                break;
        }
    }

    @Override
    public int interpret() {
        return number;
    }
}
