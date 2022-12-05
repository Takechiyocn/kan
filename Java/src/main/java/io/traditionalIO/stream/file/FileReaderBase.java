package io.traditionalIO.stream.file;

import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName FileReaderBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 1:38
 * @Version 1.0
 */
public class FileReaderBase {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/main/java/io/stream/file/file/fr.txt");
        char[] cbuf = new char[10];

        int rCount = 0;
        while ((rCount = fr.read(cbuf)) != -1) {
            System.out.println(new String(cbuf, 0, rCount));
        }

        fr.close();
    }
}
