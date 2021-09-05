package algorithms.guide.shape;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:32
 */
@Slf4j
public class Rectangle extends Shape {
    public Rectangle(double m, double n) {
        len = m;
        width = n;
    }

    @Override
    public double getArea() {
        log.warn("Rectangle area:" + len * width);
        return len * width;
    }

    private final double len;
    private final double width;
}
