package clone;

import lombok.extern.slf4j.Slf4j;
import occupation.Employee;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/28 1:37
 */
@Slf4j
public class CloneObjectTest {
    public static void main(String[] args) {
        try {
            CloneObject original = new CloneObject("A", 20000);
            original.setHireDay(2000, 1, 1);
            CloneObject copy = original.deepCopy();
            copy.raiseSalary(10);
            copy.setHireDay(2010, 2, 2);
            log.info("Original: name=" + original.getName() + ",hireDay=" + original.getHireDay() + ",salary=" + original.getSalary());
            log.info("Copy: name=" + copy.getName() + ",hireDay=" + copy.getHireDay() + ",salary=" + copy.getSalary());

            Employee el = new Employee("test");
            // 由于Object中的clone没有方法体，故不能直接使用clone
            // TODO: 关于protected子类权限问题。 object的子类代码中可以访问object。而不是子类对象可以访问object的方法。
            //  比如B是A的子类，A有一个protected的方法one,B中代码可以访问A。但是如果有一个C类，在其中有B的对象b，b.one()就不对了
//            Employee el2 = el.clone();
            System.out.println(el);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
