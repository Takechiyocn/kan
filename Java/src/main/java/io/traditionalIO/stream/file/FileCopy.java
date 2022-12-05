package io.traditionalIO.stream.file;

import java.io.*;

/**
 * @ClassName FileCopy
 * @Description
 * @Author moku
 * @Date 2022/11/30 1:10
 * @Version 1.0
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {

        // Use FileInputStream&FileOutputStream
        fileCopyByFisFos();

        // Use FileReader&FileWriter
        fileCopyByFrFw();
    }

    private static void fileCopyByFrFw() throws IOException {
        FileReader fr = new FileReader("src/main/java/io/stream/file/file/copyFrom.txt");
        FileWriter fw = new FileWriter("src/main/java/io/stream/file/file/copyToChars.txt", false);

        char[] cbuf = new char[1024 * 1024];
        int rCount = 0;
        while ((rCount = fr.read(cbuf)) != -1) {
            // 读多少写多少
            fw.write(cbuf, 0, rCount);
        }

        fw.flush();
        fr.close();
        fw.close();
    }

    private static void fileCopyByFisFos() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/io/stream/file/file/copyFrom.txt");
        FileOutputStream fos = new FileOutputStream("src/main/java/io/stream/file/file/copyToStream.txt", false);

        // 1M
        byte[] b = new byte[1024 * 1024];
        int rCount = 0;
        while ((rCount = fis.read(b)) != -1) {
            // 读多少写多少
            fos.write(b,0,rCount);
        }

        fos.flush();
        fis.close();
        fos.close();
    }
}
