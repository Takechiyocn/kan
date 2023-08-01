package logic.algorithms.guide.shape;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/25 23:32
 */
public class Shape implements Comparable {
    public Shape() {
    }

    public double getArea() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        Shape shape = (Shape) o;
        return Double.compare(this.getArea(),shape.getArea());
    }
}
