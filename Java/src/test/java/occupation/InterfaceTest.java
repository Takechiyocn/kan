package occupation;

import logic.occupation.Employee;
import logic.occupation.Manager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kan
 */
@Slf4j
public class InterfaceTest {
    public static void main(String[] args) {
        // 接口测试
        ArrayList<Employee> staffArray = new ArrayList<>();
        staffArray.add(new Employee("user1", 30000));
        staffArray.add(new Employee("user2", 20000));
        interfaceTest(staffArray);
    }

    public static void interfaceTest(ArrayList<Employee> staffArray) {
        // ArrayList转List
        Employee[] newStaff = staffArray.toArray(new Employee[0]);
        //        Employee[] newStaff = staffArray.toArray(new Employee[staffArray.size()]);
        for (Employee e : newStaff) {
            log.info("Before sort:name=" + e.getName() + ",salary=" + e.getSalary());
        }
        // Arrays的sort使用条件：对象类必须实现了Comparable接口
        Arrays.sort(newStaff);
        for (Employee e : newStaff) {
            log.info("After sort:name=" + e.getName() + ",salary=" + e.getSalary());
        }
        Manager newManager = new Manager("manager",50000,1991,1,1);
        // 不存在强制类型转换，newManager调用父类的方法
        if (newManager.compareTo(newStaff[0]) > 0) {
            log.info("1.Manager is higher");
        } else {
            log.info("1.Employee is higher");
        }
        // 强制类型转换，下转上
        if (newStaff[0].compareTo(newManager) > 0) {
            log.info("2.Employee is higher");
        } else {
            log.info("2.Manager is higher");
        }
    }
}
