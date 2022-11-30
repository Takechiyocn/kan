package errohandler.assertsystem;

import java.util.Map;
import java.util.Scanner;

/**
 * @description: 断言assert
 * @author: Kan
 * @date: 2021/3/5 21:49
 */
public class StackTrace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n:");

        int n = in.nextInt();
        assert n > 0 : "断言输出应大于0，实际输出=" + n;

        System.out.println("Input:" + n);
        System.out.println("Result:" + factorial(n));
    }

    /**
     * 阶乘：打印栈信息/栈轨迹
     * @Params:[n]
     * @Returns:int
     */
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
            StackTraceElement[] framesThread = map.get(th);
            for (StackTraceElement f : framesThread) {
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
