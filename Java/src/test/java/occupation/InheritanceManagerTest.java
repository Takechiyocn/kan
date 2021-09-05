package occupation;

import lombok.extern.slf4j.Slf4j;

/**
 * 经理类
 *
 * @author kan
 */
@Slf4j
public class InheritanceManagerTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[5];
        // 将子类对象赋值给超类对象
        staff[0] = new Employee("Employee:Carl", 90000, 2000, 10, 1);
        staff[1] = new Employee("Employee:Harry", 85000, 2001, 10, 1);
        staff[2] = new Employee("Employee:Alice", 50000);
        staff[3] = new Employee(60000);
        staff[4] = new Employee();
        // 继承测试
        testManagerInheritance(staff);

        Manager[] managers = new Manager[2];
        managers[0] = new Manager("aa",11,1990,1,1);
        managers[1] = new Manager("aa",11,1990,1,1);
        // 下转上OK
        Employee[] employees = managers;
        // 因为managers和employees指向同一个引用， 上转下NG，产生ArrayStoreException
//        employees[0] = new Employee();

        // compareTo测试
        log.info(("compareTo result:" + staff[0].compareTo(staff[1])));
    }

    /**
     * 继承
     *
     * @param staff
     */
    private static void testManagerInheritance(Employee[] staff) {
        // 强制类型转换：向下转换（超类转换为子类）
        // a instanceof b: 当对象a为类/接口b的对象或者是其直接或者间接的子类，或者是其接口的实现类，则返回true
        Manager boss;
        if (staff[0] instanceof Manager) {
            boss = (Manager) staff[0];  // Cast Error
        } else {
            boss = new Manager("Boss:Carl1", 180000, 2000, 10, 1);
        }
        boss.setBonus(50000);

        // 强制类型转换：向上转换（子类转换为超类）
        Manager boss1 = new Manager("Boss:Tom", 80000, 2000, 10, 1);
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

        log.info("Employee Staff[0] instanceof Employee:" + (staff[0] instanceof Employee));
        log.info("Employee Staff[0] instanceof Manager:" + (staff[0] instanceof Manager));
        log.info("Employee Staff[1] instanceof Manager:" + (staff[1] instanceof Manager));
        log.info("Employee Staff[1] instanceof Object:" + (staff[2] instanceof Object));

        // 子类对象可以声明为父类类型（向上转换）
        //  --> 向下转换的基础
        Employee e1 = new Manager("test", 10000, 1111, 11, 11);
        // 父类对象不可以声明为子类类型
        // Manager m1 = new Employee("test"); // cast error
        // 向下转换
        Manager m2 = (Manager) e1;
        m2.setBonus(1000);
        // boolean result = obj instanceof Class:
        //   obj:为一个对象
        //   Class:表示一个类或者一个接口
        //   判断结果:当obj为Class对象，或者是其直接或间接子类，或者是其接口的实现类，则返回true，否则返回false
        // true: el = Manager
        log.info("el instanceof Employee:" + (e1 instanceof Employee));
        // true
        log.info("el instanceof Manager:" + (e1 instanceof Manager));
        log.info("向下转换：" + m2.getName() + ", bonus:" + m2.getSalary());
        log.info("getClass of Employee:" + staff[2].getClass());
        log.info("getClass of Manager:" + m2.getClass());

        // 超类Object实例
        Object obj = new Employee("test");
        Employee e2 = (Employee) obj;

        log.info("Object.toString: of Employee:" + e2.toString());
        log.info("Object.toString of Manager:" + m2.toString());



    }
}
