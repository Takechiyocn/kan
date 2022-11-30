package io.stream.standardoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ClassName PrintStreamBase
 * @Description 标准字节输出流，默认输出到控制台，即System.out.println()方法
 * @Author moku
 * @Date 2022/12/1 1:06
 * @Version 1.0
 */
public class PrintStreamBase {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello world!");

        PrintStream out = System.out;
        out.println("Hello world again!");

        // 日志框架原理
        PrintStream log = new PrintStream(new FileOutputStream("src/main/java/io/standardize/file/log", true));
        // 修改输出方向
        System.setOut(log);
        System.out.println("Hello world2!");
        System.out.println("Hello world again2!");
    }
}
