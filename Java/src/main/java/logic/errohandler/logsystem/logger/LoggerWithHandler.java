package logic.errohandler.logsystem.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;



/**
 * Java日志记录器
 *   1. 基本日志：全局日志记录器
 *   2. 高级日志：定义(父)日志记录器
 * @author moku
 */
public class LoggerWithHandler {

    /**
     * 2. 高级日志：定义(父)日志记录器(子记录器会继承父记录器的日志级别)
     *    未被任何变量引用的日志记录器可能会被垃圾回收。
     * 日志级别(指定级别后，更高级别信息也会被记录，如指定FINE，FINE~SERVE会被记录)：
     * SEVERE (highest value)          // 默认记录
     * WARNING                         // 默认记录
     * INFO                            // 默认记录（如设置比INFO级别更低，则需修改日志处理器配置）
     * CONFIG
     * FINE
     * FINER
     * FINEST (lowest value)
     */
    private static final Logger LOGGER = Logger.getLogger("com.company.myapp");

    public static void main(String[] args) {
        // 1. 基本日志：全局日志记录器
        Logger.getGlobal().info("Global logger set");
        Logger.getGlobal().setLevel(Level.OFF);
        // 取消全局日志记录器
        Logger.getGlobal().info("Global logger canceled");

        // 高级日志记录
        LoggerWithHandler mainIns = new LoggerWithHandler();
        mainIns.getLoggerInfo();
    }

    public void getLoggerInfo() {
        // 设置记录器的日志级别
        LOGGER.setLevel(Level.FINER);
        // 记录日志方法：
        LOGGER.warning("Waring message!");
        LOGGER.log(Level.INFO, "Info message!");
        // 虚拟机对执行过程优化后采用该方法获取准确信息
        LOGGER.logp(Level.INFO, "logger.LoggerWithHandler", "getLoggerInfo", "虚拟机对执行过程优化后采用该方法获取准确信息");

        // 日志输出处理程序
        loggerHandler("logic/test");
    }

    public void loggerHandler(String filename) {
        try {
            // 注册输出处理程序1:打印到指定文件
            // TODO:为什么IOException需要FINER级别才能打印
            FileHandler fileHandler = new FileHandler("fileHandler.log", false);
            // 30：指定单个文件大小、0：使用多少个文件记录
//            FileHandler fileHandler = new FileHandler("fileHandler.%g%u.log", 30,0,false);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.FINER);

            // 注册输出处理程序2:打印到控制台
            // TODO:为什么IOException需要FINER级别才能打印
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.FINER);
            LOGGER.addHandler(consoleHandler);

            // 父日志记录器(root Logger所属)不记录（2重记录）
            LOGGER.setUseParentHandlers(false);

            InputStream is = new FileInputStream(filename);
            int b;
            while ((b = is.read()) != -1) {
                System.out.println("Read:" + b);
            }
        } catch (FileNotFoundException e) {
            // throwing:记录下来的信息转发到已注册的输出处理程序
            // 记录FINER级别的记录和一条以THROW开始的信息
            LOGGER.throwing(this.getClass().getName(), this.getClass().getMethods()[0].getName(), e);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, "read error", e);
//            e.printStackTrace();
        }
    }
}
