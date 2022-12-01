package io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName FileCopy
 * @Description 文件拷贝
 * @Author moku
 * @Date 2022/12/1 11:09
 * @Version 1.0
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("src/main/java/io/file/file/temp.txt");
        FileOutputStream fos = new FileOutputStream("src/main/java/io/file/file/tempTo.txt");

        byte[] b = new byte[1024 * 1024];
        int rCount = 0;
        while ((rCount = fis.read(b)) != -1) {
            fos.write(b, 0, rCount);
        }

        fos.flush();
        fis.close();
        fos.close();
    }
}
