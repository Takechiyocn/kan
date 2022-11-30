package io.stream.file;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName FileInputStreamBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 0:18
 * @Version 1.0
 */
public class FileInputStreamBase {
    public static void main(String[] args) throws IOException {

        // 读取文件：一次1byte
//        fileInputStreamRead();

        // 循环读取文件：一次1byte
//        fileInputStreamLoopRead();

        // 循环读取文件：一次读取指定byte
        fileInputStreamLoopReadSpecified();
    }

    private static void fileInputStreamLoopReadSpecified() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/io/stream/file/file/fis.txt");

        int i = 0;
        int rCount = 0;
        byte[] bytes = new byte[4];

        // 流中字节数
        System.out.println("流中字节总数：" + fis.available());

        // 跳过指定字节不读
        fis.skip(3);

        while ((rCount = fis.read(bytes)) != -1) {
            // TODO：换行\r字符串 无法输出(sout时换行前内容被截断)
            String s = new String(bytes, 0, rCount);
            System.out.println("Loop read, read [" + (++i) + "] times, and data=[" + s + "]");
        }

        fis.close();
    }

    private static void fileInputStreamLoopRead() throws IOException {
        FileInputStream fis = null;
        fis = new FileInputStream("src/main/java/io/stream/file/file/fis.txt");

        int i = 0;
        while (true) {
            int r = fis.read();
            if (r == -1) {  // 读到文件末尾
                break;
            }
            System.out.println("Loop read, read [" + (++i) + "] times, and data=[" + r + "]");
        }

        fis.close();
    }

    private static void fileInputStreamRead() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/io/stream/file/file/fis.txt");
        // 读取一个字节，失败返回-1
        int r = fis.read();
        int r2 = fis.read();

        System.out.println("Normal read, read 1st time, and data=[" + r + "]");
        System.out.println("Normal read, read 2nd time, and data=[" + r2 + "]");


        fis.close();
    }
}
