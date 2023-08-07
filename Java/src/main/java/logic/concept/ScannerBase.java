package logic.concept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName ScannerBase
 * @Description
 * @Author moku
 * @Date 2022/12/18 23:22
 * @Version 1.0
 */
public class ScannerBase {
    public static void main(String[] args) throws IOException {

        // 读取用户输入
//        scannerInput();

        // 读取文件
        scannerFile();
    }

    private static void scannerInput() {
        // 创建一个扫描器对象，用于接收键盘数据
        Scanner s = new Scanner(System.in);

        // 字符
//        if (s.hasNext()) {
//            // 获取输入字符
//            System.out.println("输入字符：" + s.next());
//        }

        // 行
//        if (s.hasNextLine()) {
//            // 获取输入行
//            System.out.println("输入行：" + s.nextLine());
//        }

        // 整型数据
        if (s.hasNextInt()) {
            System.out.println("整型数据：" + s.nextInt());
        } else {
            System.out.println("非整型数据：" + s.next());
        }

        // 浮点型数据
        if (s.hasNextFloat()) {
            // 输入整型数据会发生强制类型转换
            System.out.println("浮点型数据：" + s.nextFloat());
        } else {
            System.out.println("非浮点型数据：" + s.next());
        }

        // System.in为静态常量，线程共享，所以同一线程内不能多次调用new Scanner(System.in);
        // public static final InputStream in = null;
        s.close();
    }

    private static void scannerFile() throws IOException {
        // 读取路径
        Scanner in = new Scanner(Paths.get("src/main/java/util/file/test.txt"), "UTF-8");
        while (in.hasNextLine()) {
            System.out.println("读取文件(Paths.get)：" + in.nextLine());
        }
        in.close();

        // 带资源的try语句：结束后自动调用close方法
        try (Scanner in2 = new Scanner(new FileInputStream("src/main/java/util/file/test.txt"))) {
            while (in2.hasNextLine()) {
                System.out.println("读取文件(FileInputStream)：" + in2.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
