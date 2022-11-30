package errohandler.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/5 0:53
 */
public class TryWithoutResources {
    public void readFile(String filename) {
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while ((b = in.read()) != -1) {
                System.out. println("Read:" + b);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("自定义错误消息：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TryWithoutResources r = new TryWithoutResources();

        // 返回当前Class这个类所在包开始的位置
        System.out.println(TryWithoutResources.class.getResource("").getPath());
        // 返回classpath位置
        System.out.println(TryWithoutResources.class.getResource("/").getPath());
        // 相对路径
        r.readFile(System.getProperty("user.dir") + "/fileNotExist.log");
    }
}
