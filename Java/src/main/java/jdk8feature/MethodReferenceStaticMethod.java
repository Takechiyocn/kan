package jdk8feature;

import lombok.extern.slf4j.Slf4j;
import superclass.Person;

import java.util.Arrays;
import java.util.List;

/**
 * 类型               语法                  对应的Lambda表达式
 * 静态方法引用        类名::staticMethod    (args) -> 类名.staticMethod(args)
 * 实例方法引用        inst::instMethod      (args) -> inst.instMethod(args)  --> 必须实例化
 * 对象方法引用        类名::instMethod      (inst,args) -> inst.instMethod(args)
 * 构建方法引用        类名::new             (args) -> new 类名(args)
 * @author moku
 */
@Slf4j
public class MethodReferenceStaticMethod {

    public static void main(String[] args) {

        Person[] person = new Person[3];
        person[0] = new Person("user1", 21);
        person[1] = new Person("user2", 18);
        person[2] = new Person("user3", 32);
        // 克隆
        Person[] person1 = person.clone();
        // 复制数组
        Person[] person2 = Arrays.copyOf(person, person.length + 1);
        person2[person.length] = new Person("user4", 23);
        // 复制数组
        Person[] person3 = Arrays.copyOf(person2, person2.length + 1);
        person3[person2.length] = new Person("user5", 10);
        for (Person p : person) {
            log.info("Before" + p.toString());
        }

        // 1.传统比较器
        Arrays.sort(person, new TraditionalComparator());
        for (Person p : person) {
            log.info("传统比较器" + p.toString());
        }

        // 2.lambda表达式
        Arrays.sort(person1, (a, b) -> a.getAge().compareTo(b.getAge()));
        for (Person p : person1) {
            log.info("lambda表达式" + p.toString());
        }

        // 3.静态方法比较器
        Arrays.sort(person2, (a, b) -> Person.compareByAge(a, b));
        for (Person p : person2) {
            log.info("静态方法比较器" + p.toString());
        }

        // 4.静态方法引用
        Arrays.sort(person3, Person::compareByAge);
        for (Person p : person3) {
            log.info("静态方法引用" + p.toString());
        }

        // 5.静态方法引用
        List<Integer> list = Arrays.asList(22, 11, 10, 80, 35);
        list.sort(Integer::compare);
        log.info("静态方法引用2" + list.toString());
    }
}
