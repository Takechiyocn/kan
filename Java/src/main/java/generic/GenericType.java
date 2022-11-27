package generic;

import occupation.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 泛型概述
 * @author: Kan
 * @date: 2021/2/23 22:37
 */
@Slf4j
public class GenericType {
    public static void main(String[] args) {
        // 数组列表只是表明该数组列表拥有保存10个元素的潜力
        // 未用add等方法追加元素前，数组列表中包含的实际元素数目为0
        ArrayList<String> arrayList = new ArrayList<>(10);
        System.out.println("声明数组列表后，数组列表未分配空间，即size=" + arrayList.size());
        // 如果能确定数组可能存储的元素数量，可用ensureCapacity方法
        arrayList.ensureCapacity(100);
        // 如果确定数组列表的大小不再发生变化，可用trimToSize方法调整存储区域大小
        // 垃圾回收器将回收多余的存储空间
        arrayList.trimToSize();
        // 分配10个元素的存储空间
        String[] array = new String[10];
        log.info("Size:" + arrayList.size());
        log.info("Size:" + array.length);
        Integer a = 100;
        Integer b = 100;
        Integer c = 1000;
        Integer d = 1000;
        // a进入缓存池，b公用该缓存池
        // Integer缓存池默认大小-128~127，因此c并未进入缓存池
        System.out.println("Equal compare use ==:" + (a == b));
        System.out.println("Equal compare use equals:" + a.equals(b));
        System.out.println("Equal compare use ==:" + (c == d));
        System.out.println("Equal compare use equals:" + c.equals(d));

        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            log.info("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }

        ArrayList<Employee> findEl = find("Tony Tester");
        for (Employee e : findEl) {
            log.info("Found: name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
        }
    }

    /**
     * 类型化与原生态类型raw use（没有使用泛型<></>）的兼容
     * 调用元是静态static类型， 所以该方法也应该是静态
     * @param query
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ArrayList find(String query) {
        ArrayList<Employee> aList = new ArrayList<>();
        aList.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        aList.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        aList.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        for (Employee e : aList) {
            if (query.equals(e.getName())) {
                return new ArrayList(Arrays.asList(e));
            }
        }
        return new ArrayList(Arrays.asList(new Employee()));
    }
}
