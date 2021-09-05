package exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/5 22:29
 */
public class LoggerNestedInJava {
    public static void main(String[] args) {
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("Logger info test");
        System.out.println("Test");
    }
}
