package io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilesList
 * @Description 遍历目录
 * @Author moku
 * @Date 2022/12/1 10:50
 * @Version 1.0
 */
public class FilesList {

    public static void getFilesList(File f, List<File> l) {
        File[] lf = f.listFiles();
        for (File fInner : lf) {
            if (fInner.isDirectory()) {
                getFilesList(fInner, l);
            } else {
                l.add(fInner);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("src/main/java/io/file/");
        List<File> lf = new ArrayList<>();
        getFilesList(f, lf);
        for (File fInner : lf) {
            System.out.println(fInner.getAbsolutePath());
        }
    }
}
