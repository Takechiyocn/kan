package logic.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 默认克隆操作为浅拷贝，不会克隆对象中引用的其他对象。
 *               如果需要深拷贝，则需实现Cloneable接口并重新定义clone方法，指定public修饰符
 *               Cloneable接口（标记接口tagging interface/记号接口marker interface）
 *               该接口没有clone方法，clone方法继承自超类Object且为protected。
 *               标记接口不包含任何方法，唯一作用是允许在类型查询中使用instanceof
 *
 *               标记接口：没有方法的接口
 * @author: Kan
 * @date: 2021/2/28 1:10
 */
public class DeepClone implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public DeepClone(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 浅拷贝也需要实现implement Cloneable接口，实现该接口即可调用
     *
     */
    public DeepClone shallowCopy() throws CloneNotSupportedException {
        return (DeepClone) super.clone();
    }

    /**
     * 深拷贝
     */
    public DeepClone deepCopy() throws CloneNotSupportedException {
        DeepClone cloned = (DeepClone) super.clone();

        // 克隆可变域
        // String对象属于一个不可变的类，所以name不必克隆
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
}
