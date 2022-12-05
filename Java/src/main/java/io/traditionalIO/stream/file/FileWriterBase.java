package io.traditionalIO.stream.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileWriterBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 1:44
 * @Version 1.0
 */
public class FileWriterBase {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("src/main/java/io/stream/file/file/fw.txt", true);
        char[] cbuf = {'我','是','中','国','人'};

        fw.write(cbuf);
        fw.write(cbuf, 0, 2);
        fw.write("hello world!");

        fw.flush();
        fw.close();
    }
}
