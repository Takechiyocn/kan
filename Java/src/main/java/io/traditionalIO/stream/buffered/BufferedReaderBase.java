package io.traditionalIO.stream.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName BufferedReaderBase
 * @Description
 * @Author moku
 * @Date 2022/11/30 1:54
 * @Version 1.0
 */
public class BufferedReaderBase {
    public static void main(String[] args) throws IOException {

        // 节点流(FileReader)：当一个流的构造方法中需要一个流时，这个被传进来的流叫做节点流
        FileReader fr = new FileReader("src/main/java/io/stream/buffered/file/fr.txt");
        // 包装流/处理流(BufferedReader)：外部负责包装的这个流叫做包装流
        BufferedReader br = new BufferedReader(fr);

        String s = null;
        // 读取一行，不带换行(line feed)回车(carriage return)
        while((s = br.readLine())!= null) {
            System.out.println(s);
        }

        // 关闭包装流：节点流会自动关闭
        br.close();
    }
}
