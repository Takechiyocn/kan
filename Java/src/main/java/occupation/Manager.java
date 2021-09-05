package occupation;

import java.util.Objects;

/**
 * @author Kan
 * @description: final类不允许扩展(阻止继承)
 * 将类声明为final，方法自动称为final，不包括域
 * @date 2021/2/15 22:18
 */
public class Manager extends Employee {
    private double bonus;
    private String seat = "";

    /**
     * constructor of Manager
     *
     * @param name   name
     * @param salary salary
     * @param year   year
     * @param month  month
     * @param day    day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
        seat = "A";
    }

    public Manager(String name) {
        super(name);
    }

    /**
     * get Manager salary
     *
     * @return manager salary
     */
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    /**
     * set bonus
     *
     * @param bonus bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * get bonus
     *
     */
    public double getBonus() {
        return this.bonus;
    }

    /**
     * get seat
     *
     * @return seat
     */
    public String getSeat() {
        return this.seat;
    }

//    /**
//     * 重写Object.equals方法
//     *
//     * @param otherObject
//     * @return
//     */
//    @Override
//    public boolean equals(Object otherObject) {
//        if (!super.equals(otherObject)) {
//            return false;
//        }
//
//        // 子类重写overwriting时，强制类型转换可能发生从上向下转换的ClassCastException
//        // 尽管下面的强制类型转换不会发生(超类getClass返回false)，但会有潜在风险
//        Manager other = (Manager) otherObject;
//        // TODO: 浮点类型数据相等判断
//        return bonus == other.bonus;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus, seat);
    }

    @Override
    public String toString() {
        return super.toString()
                + "[bonus=" + bonus
                + "]";
    }
}
