package algorithms.guide.shape;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:32
 */
@Slf4j
public class Circle extends Shape {
    public Circle(double a) {
        area = a;
    }

    @Override
    public double getArea() {
        log.warn("Circle area:" + Math.pow(area,2) * PI);
        return PI * area * area;
    }

    private final double area;
    private  static final double PI = 3.14;
}
