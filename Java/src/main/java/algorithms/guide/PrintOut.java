package algorithms.guide;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/24 23:42
 */
@Slf4j
public class PrintOut {
    public static void main(String[] args) {
        printOut(76234);
    }

    public static void printOut(int n) {
        if (n > 10) {
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    private static void printDigit(int i) {
        log.info("Value:" + i);
    }
}
