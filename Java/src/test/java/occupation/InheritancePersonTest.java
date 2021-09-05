package occupation;

import abstclass.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kan
 */
@Slf4j
public class InheritancePersonTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[5];
        // 将子类对象赋值给超类对象
        staff[0] = new Employee("Carl", 90000, 2000, 10, 1);
        staff[1] = new Employee("Harry", 85000, 2001, 10, 1);
        staff[2] = new Employee("Alice", 50000);
        staff[3] = new Employee(60000);
        staff[4] = new Employee();
        // 继承测试
        testManagerInheritance(staff);
    }

    private static void testManagerInheritance(Employee[] staff) {
        // 强制类型转换：向下转换（超类转换为子类）
        Manager boss;
        if (staff[0] instanceof Manager) {
            boss = (Manager) staff[0];
        } else {
            boss = new Manager("Carl1", 180000, 2000, 10, 1);
        }
        boss.setBonus(50000);

        // 强制类型转换：向上转换（子类转换为超类）
        Manager boss1 = new Manager("Tom", 80000, 2000, 10, 1);
        // staff[4]和boss1引用同一个(Manager)对象，但编译器将staff[4]看成Employee对象
        //   --> staff[4].setBonus会报错
        staff[4] = boss1;
        // staff[4].setBonus(50000); // Cannot resolve method 'setBonus' in 'Employee'
        boss1.setBonus(50000);

        // Alice raise salary by 5%
        staff[1].raiseSalary(5);

        // 对象变量(e)可以指示多种实际类型的现象称为多态polymorphism
        // 运行时能够自动选择调用哪个方法的现象称为动态绑定dynamic binding(e.getSalary)
        for (Employee e : staff) {
            log.info("Before:name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }
//        log.info("Staff[0] instanceof Employee:" + (staff[0] instanceof Employee));
//        log.info("Staff[0] instanceof Manager:" + (staff[0] instanceof Manager));
//        log.info("Staff[1] instanceof Employee:" + (staff[1] instanceof Manager));
    }
}
