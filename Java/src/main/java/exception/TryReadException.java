package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/5 0:53
 */
public class TryReadException {
    public void read(String filename) {
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while ((b = in.read()) != -1) {
                System.out. println("Read:" + b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("自定义错误消息：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
