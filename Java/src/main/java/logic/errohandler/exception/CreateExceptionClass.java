package logic.errohandler.exception;

import java.io.IOException;

/**
 * 创建异常类：定义一个派生于Exception的类，或者派生于Exception子类的类
 * @author moku
 */
public class CreateExceptionClass extends IOException {

    public CreateExceptionClass() {
    }

    public CreateExceptionClass(String gripe) {
        super(gripe);
    }
}
