package logutil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName LogUtil
 * @Description 自定义日志系统
 * @Author moku
 * @Date 2022/12/1 1:18
 * @Version 1.0
 */
public class LogUtil {
    public static void log(String msg) {
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/logutil/file/log.txt", true));
            // 改变流输出方向
            System.setOut(ps);
            // 获取系统当前时间
            Date nowTime = new Date();
            // 日期格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);
            System.out.println(strTime + ":" + msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogUtil.log("自定义日志系统");
        LogUtil.log("Hello world!");
    }
}
