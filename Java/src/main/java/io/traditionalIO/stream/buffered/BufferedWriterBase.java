package io.traditionalIO.stream.buffered;

import java.io.*;

/**
 * @ClassName BufferedWriterBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 2:07
 * @Version 1.0
 */
public class BufferedWriterBase {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/io/stream/buffered/file/bw.txt"));
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/io/stream/buffered/file/bw2.txt")));

        bw.write("hello world!");
        bw2.write("hello world!");
        bw.write("\n");
        bw2.write("\n");
        bw.write("我是中国人");
        bw2.write("我是中国人");

        bw.flush();
        bw2.flush();
        bw.close();
        bw2.close();
    }
}
