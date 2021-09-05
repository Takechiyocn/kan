package interfacecustomize;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/28 0:33
 */
public class ArraysComparable implements Comparable<ArraysComparable> {
    private final double salary;

    public ArraysComparable(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(ArraysComparable o) {
        return Double.compare(salary, o.geSalary());
    }

    public final double geSalary() {
        return salary;
    }

}
