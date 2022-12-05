package io.traditionalIO.stream.file;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileIOBase
 * @Description File对象可能是木火或文件
 * @Author moku
 * @Date 2022/12/1 1:28
 * @Version 1.0
 */
public class FileIOBase {
    public static void main(String[] args) throws IOException {

        File f = new File("src/main/java/io/file/file/temp.txt");


        // 判断文件是否存在
        System.out.println(f.exists());

        // 不存在则创建：以文件形式
        if (!f.exists()) {
            f.createNewFile();
        }

        // 不存在则创建：以目录形式
        if (!f.exists()) {
            f.mkdir();
        }

        // 不存在则创建：以目录形式
        if (!f.exists()) {
            f.mkdir();
        }

        // 不存在则创建：以多重目录形式
        File f2 = new File("src/main/java/io/file/files/temp.txt");
        if (!f2.exists()) {
            f2.mkdirs();
        }

        File dir = new File("src/main/java/io/file/dir1/dir2/s.txt");
        System.out.println(dir.getParentFile());
        // 创建多重目录：标准版
        // 条件1：文件路径(路径不一定真实存在)
        // 条件2：dir不存在目录时，条件为false，!false = true 即 创建
        if (dir.getParentFile() != null || !dir.getParentFile().isDirectory()) {
            dir.getParentFile().mkdirs();
        }

        // 获取路径：文件父路径
        String path = f.getParent();
        System.out.println(path);
        // 获取路径：文件路径(路径不一定真实存在)
        // getParentFile返回对象可用于getAbsolutePath()方法
        File parentFile = f.getParentFile();
        System.out.println(parentFile);
        // 获取路径：文件绝对路径
        System.out.println("绝对路径" + parentFile.getAbsolutePath());

        System.out.println("文件名：" + f.getName());
        // 判断是否是目录
        System.out.println("是否是一个目录：" + f.isDirectory());
        // 判断是否是文件
        System.out.println("是否是一个文件：" + f.isFile());

        // 获取文件最后一次修改时间：返回毫秒
        System.out.println("文件最后一次修改时间：" + f.lastModified());
        // 文件字节大小
        System.out.println("文件大小：" + f.length());
    }
}
