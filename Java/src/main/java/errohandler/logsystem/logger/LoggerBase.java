package errohandler.logsystem.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @description: Java日志记录器Logger
 * @author: Kan
 * @date: 2021/3/5 22:29
 */
public class LoggerBase {
    public static void main(String[] args) {

        // 全局日志记录器
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("Logger info test: turn off logging");
        Logger.getGlobal().setLevel(Level.INFO);
        Logger.getGlobal().info("Logger info test: turn on info logging");
        System.out.println("Test");
    }
}
