package io.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName FileOutputStreamBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 1:00
 * @Version 1.0
 */
public class FileOutputStreamBase {
    public static void main(String[] args) throws IOException {

        // true：追加写
        FileOutputStream fos = new FileOutputStream("src/main/java/io/file/file/fos.txt", true);
        // 写出整个数组：a=97,b,c,d
        byte[] bytes = {97, 98, 99, 100};
        fos.write(bytes);
        // 写出指定数量：a,b
        fos.write(bytes,0,2);

        String s = "hello world!";
        byte[] bytes2 = s.getBytes(StandardCharsets.UTF_8);
        fos.write(bytes2);

        fos.flush();
    }
}
