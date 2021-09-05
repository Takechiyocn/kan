package algorithms.guide;

import algorithms.guide.shape.Circle;
import algorithms.guide.shape.Rectangle;
import algorithms.guide.shape.Shape;
import algorithms.guide.shape.Square;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:37
 */
@Slf4j
public class FindMaxDemo {
    public static void main(String[] args) {
        Shape[] sh1 = {
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0, 4.0)
        };

        String[] st1 = {"Joe", "Bob", "Bill", "Zeke"};

        System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
        Arrays.sort(sh1);
        Arrays.sort(st1);
        for (Shape shape : sh1) {
            log.info("Use Arrays.sort():" + shape);
        }
        for (String s : st1) {
            log.info("Use Arrays.sort():" + s);
        }
    }

    /**
     * 原始Comparable类型
     *
     * @param arr
     * @return
     */
    private static Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
