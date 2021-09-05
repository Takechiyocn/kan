package jdk8feature;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Date;
import java.util.function.Consumer;

/**
 * @author moku
 * @description: 函数式接口functional interface：对于只有一个抽象方法的接口，需要这种接口的对象时
 * Lambda并不是任何地方都可以使用，Lambda表达式需要“函数式接口”的支持。
 * 可以提供一个lambda表达式，这种接口称为函数式接口，可以用@FunctionalInterface修饰一下
 * 未使用 @FunctionalInterfaces注解的接口未必就不是函数式接口，
 * 一个接口是不是函数式接口的条件只有一条，即接口中只有一个抽象方法的接口（Object类中的方法不算）。
 * 而使用@FunctionalInterface注解修饰了的接口就一定是函数式接口，添加@FunctionalInterface注解可以帮助我们检查是否是函数式接口。
 */
@Slf4j
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        // 普通线程
        test.threadPrint();

        // 函数式接口创建线程
        test.threadPrintLambda("函数式接口创建线程");

        // 函数式接口创建回调（Timer）
        test.timerPrint();

        // 语法格式1：无参数，无返回值(Runnable接口)
        test.threadPrintLambda("语法格式1");

        // 语法格式2：1个参数，无返回值(Consumer消费型接口)
        test.doPrint("语法格式2:1个参数，无返回值");

        // 语法格式3：lambda体内只有一条语句，且有返回值，return可省略
        LambdaCalculator test2 = new LambdaCalculator();
        System.out.println(test2.add(10, 5));

        // 语法格式4：有2个以上参数，且lambda体中有多条语句
        System.out.println(test2.minus(10, 5));

        // 语法格式5：lambda表达式的数据类型可以省略不写（JVM编译器通过上下文可以推断出数据类型）
        System.out.println(test2.multi(10, 5));
    }

    /**
     * 普通线程
     */
    public void threadPrint() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, world!");
            }
        });

        thread.start();
    }

    /**
     * 函数式接口创建线程
     * lambda表达式可以捕获外围方法中的变量(TODO：闭包closure)
     * 前提条件：该变量为最终变量effectively final，即该变量初始化之后就不能再改变，如String
     * lambda表达式的体与嵌套块有相同作用于，即局部变量名会发生冲突
     *
     */
    public void threadPrintLambda(String text) {
        Runnable target;
        Thread thread = new Thread(() -> System.out.println("Hello, Lambda!" + text));
        thread.start();
    }

    /**
     * 函数式接口创建回调（Timer）
     */
    public void timerPrint() {
        // 使用ActionListener的函数式接口(此时不必覆盖/重载函数：actionPerformed,因为函数式接口抽放方法已经定义具体实现)
//        Timer t = new Timer(10000, e -> log.info("The time is " + new Date()));
        new Timer(2000, e -> log.info("The time is " + new Date())).start();

//        t.start();
    }

    /**
     * 消费型接口(无返回值，有去无回)
     *
     * @param consumer
     */
    public void print(Consumer<String> consumer) {
        consumer.accept(null);
    }

    public void doPrint(String msg) {
        print((str) -> System.out.println(msg));
        print(str -> System.out.println(msg));
    }

}
