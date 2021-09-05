package algorithms.guide.shape;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:32
 */
@Slf4j
public class Square extends Shape {
    public Square(double a) {
        area = a;
    }

    @Override
    public double getArea() {
        log.warn("Square area:" + area * area);
        return area * area;
    }

    private final double area;
}
