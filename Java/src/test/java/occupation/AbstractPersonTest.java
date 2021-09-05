package occupation;

import abstclass.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 经理类
 *
 * @author kan
 */
@Slf4j
public class AbstractPersonTest {
    public static void main(String[] args) {
        // 抽象类测试
        // 可以定义一个抽象类的对象变量，但他只能引用非抽象子类的对象
        Person[] people = new Person[2];
        people[0] = new Manager("Carl", 90000, 2000, 10, 1);
        people[1] = new Student("Student1", "Math");
        abstractPersonTest(people);
    }

    public static void abstractPersonTest(Person[] people) {
        // 不能构造抽象类的对象，所以p永远不会引用Person对象。而是引用Manager,Student对象
        for (Person p : people) {
            log.info(p.getName() + ", " + p.getDescription());
        }
    }
}
