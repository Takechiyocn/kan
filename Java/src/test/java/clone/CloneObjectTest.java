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
            // String:不变对象
            copy.setName("B");
            log.info("Deep copy(original): name=" + original.getName() + ",hireDay=" + original.getHireDay() + ",salary=" + original.getSalary());
            log.info("Deep copy(new): name=" + copy.getName() + ",hireDay=" + copy.getHireDay() + ",salary=" + copy.getSalary());

            Employee el = new Employee("test");
            // protected权限的Object.clone方法：包和子类(代码中，非子类对象)可见
            // 比如B是A的子类，A有一个protected的方法aMethod,B中代码可以访问aMethod。但是如果有一个C类，在其中有B的对象b，b.aMethod()就不对了
            // 以下Employee类(中方法)可访问继承自Object的clone方法
            // 如Employee实现Cloneable接口并重写clone方法，以下方法可执行
//            Employee el2 = el.clone();
            System.out.println(el);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
