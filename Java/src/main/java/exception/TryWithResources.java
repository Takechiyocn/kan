package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @description: 带资源的try语句实现了AutoCloseable类或其子类(如Closeable)时，
 * 调用结束后会自动调用close关闭资源
                * @author: Kan
                * @date: 2021/3/5 0:53
                */
        public class TryWithResources {

            public void read(String filename) {
                // Scanner实现了Closable接口，可以不用try final形式，会自动调用close关闭资源
                // close关闭资源时抛出的异常会被抑制。
                try (Scanner in = new Scanner(new FileInputStream(filename))) {

            // 1. 抛出FileNotFoundException异常
            while (in.hasNext()) {
                System.out.println("Read:" + in.toString());
            }
        } catch (FileNotFoundException e) {
            // 2. 捕获FileNotFoundException异常（只打印栈信息），如果要抛出异常，原来用的try fina话，该异常会被close异常覆盖
            e.printStackTrace();
        }

        // 3. Closeable的close方法关闭资源（相当于之前得try final的final语句）
        // 4. close发生异常。该异常被自动捕获并用addSuppressed方法增加到原来的异常中。
        //    可由getSuppressed方法获取被抑制的异常列表
        // 5  带资源的try语句可以使用finally，在close关闭资源后执行。
        finally {
            // 原始关闭资源方法
//            in.close();
            System.out.println("没有必要的final语句");
        }
    }
}
