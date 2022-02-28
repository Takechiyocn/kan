package exception;

import java.util.Map;
import java.util.Scanner;

/**
 * @description: 断言assert
 * @author: Kan
 * @date: 2021/3/5 21:49
 */
public class StackTraceClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n:");

        int n = in.nextInt();
        // 断言：允许在测试期间插入一些检查语句，代码发布时这些插入的检测语句会被自动移走。
        //      当条件检测结果为false时，会抛出AssertionError异常（assert a!=null,当a为null时抛出 -->前置条件Precondition）
        //   1. assert 条件
        //   2. assert 条件：表达式  （表达式会被传入AssertionError构造器中并转换成一个消息字符串）
        //      -> AssertionError对象并不存储表达式的值，不可能在以后得到它。
        //   默认禁用。开启：-enableassertions或-ea。 开起关闭不用重新编译，属于类加载器功能
        //            禁用：-disableassertions或-da。
        //   系统类没有类加载器，启用或禁用断言时，需用-enablesystemassertions或-esa。
        //  使用场景：测试和调试阶段使用。
        //  分类：类加载器的类
        //       虚拟机加载的类（系统类）
        //  方法（类加载器的类）：
        //    setDefaultAssertionStatus:启用/禁用包或类的断言状态
        //    setClassAssertionStatus：启用/禁用类（包括内部类）的断言状态
        //    setPackageAssertionStatus：启用/禁用包和其子包的断言状态
        //    clearAssertionStatus：移去所有类和包的显式断言状态设置，并禁用所有通过这个类加载器加载的类的断言。
        //  语法：assert 表达式 : 断言信息
        //    -> 当表达式不为true时抛出异常，即断言这个表达式一定为true
        assert n > 0 : "n<=0";

        System.out.println("Input:" + n);
        System.out.println("Result:" + factorial(n));
    }

    public static int factorial(int n) {
        int r;
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();

        // 堆栈轨迹数组
        for (StackTraceElement f : frames) {
            System.out.println("getStackTrace:" + f);
        }

        // 获取所有线程的堆栈轨迹：静态方法
        Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread th : map.keySet()) {
            StackTraceElement[] frames1 = map.get(th);
            for (StackTraceElement f : frames1) {
                System.out.println("getAllStackTraces:" + f);
            }
        }

        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }

        System.out.println("Return:" + r);

        return r;
    }
}
