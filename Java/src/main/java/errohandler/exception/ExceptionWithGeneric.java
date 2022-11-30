package errohandler.exception;

import java.io.File;
import java.util.Scanner;

/**
 * 约束与局限性9：消除对受查异常的检查，即让编译器认为是一个非受查异常
 * // TODO:线程后再看
 * @author moku
 */
public abstract class ExceptionWithGeneric {

    public abstract void body() throws Exception;

    public Thread toThread() {
        return new Thread() {
            @Override
            public void run() {
                try {
                    body();
                } catch (Throwable t) {
                    ExceptionWithGeneric.<RuntimeException>throwAs(t);
                }
            }
        };
    }

    /**
     * 泛型消除对受查异常的检查
     * @param e
     * @param <T>
     * @throws T
     */
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e;
    }

    /**
     * 正常情况：因为run方法声明为不抛出任何受查异常，
     * 所以必须捕获线程run方法中的所有受查异常，并把它们包装到非受查异常中。
     * 该程序处理：利用泛型消除对受查异常的检查，欺骗编译器让它认为这不是一个受查异常。
     *
     * @param args
     */
    public static void main(String[] args) {
        new ExceptionWithGeneric() {
            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("test"), "UTF-8");
                while (in.hasNext()) {
                    System.out.print(in.next());
                }
            }
        }.toThread().start();
    }
}

