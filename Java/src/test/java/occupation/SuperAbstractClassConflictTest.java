package occupation;

import abstclass.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kan
 */
@Slf4j
public class SuperAbstractClassConflictTest {
    public static void main(String[] args) {
        // 超类(抽象类)/接口默认方法冲突
        // 1. 超类有冲突，超类优先
        // 2. 接口冲突，用户覆盖其中一个默认方法
        testDefaultMethodConflict();
    }

    public static void testDefaultMethodConflict() {
        // 1. 超类和接口有冲突，超类优先
        // 类优先原则:超类和接口方法冲突时，超类方法优先，接口是否提供默认实现（保证接口兼容性）没有区别
        Person[] people = new Person[2];
        people[0] = new Student("Student1", "Maths");
        people[1] = new Student("Student2", "Maths");
        for (Person p : people) {
            log.info("Student:" + p.getName());
        }

        // 2. 接口冲突，用户覆盖其中一个默认方法
        Teacher[] people1 = new Teacher[1];
        people1[0] = new Teacher("Six");
        for (Teacher p : people1) {
            log.info(p.getName());
            log.info(p.getDescription());
        }
    }
}
