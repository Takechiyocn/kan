package comparator;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/3 0:01
 */
@Slf4j
public class ProfessionalComparator extends TraditionalComparator {

    public static void main(String[] args) {

        Person[] people = new Person[5];
        people[0] = new Person("Student33", "middleName3", "firstName3", 11);
        people[1] = new Person("Student1", 40);
        people[2] = new Person("Student1", "middleName2", "firstName1", 30);
        people[3] = new Person("Student199");
        people[4] = new Person("Student1", "middleName1", "firstName1", 20);

        // 1. Arrays.comparing()
        // 键：姓，比较器：默认 -> 姓字符升序
        // Arrays.comparing代替手动实现comparator
        // 对象发方法引用（第一个参数是实例方法的参数调用者，第二个参数是实例方法的参数）
        Arrays.sort(people, Comparator.comparing(Person::getLastName));
        // 对象方法调用：lambda表达式
//        Arrays.sort(people, Comparator.comparing(p -> {return p.getLastName();}));
        // 传统比较器接口
//        Arrays.sort(people, new TraditionalComparator());
        log.info("1.Person::getName(默认比较器)");
        printPersonInfo(people);

        // 2. Arrays.comparing()
        // 键：姓，比较器：指定比较器 -> 按姓名长度
        Arrays.sort(people, Comparator.comparing(Person::getLastName, (s, t) -> Integer.compare(s.length(), t.length())));
        log.info("2.Person::getName(键指定比较器)");
        printPersonInfo(people);

        // 3. Arrays.comparing().thenComparing()
        //  键：姓，比较器：默认 -> 姓字符升序，若姓相同，则按年龄符升序(若字段可能为null，则应采取4.或者6.处理处理)
        Arrays.sort(people, Comparator.comparing(Person::getLastName).thenComparing(Person::getAge));
        log.info("3.Arrays.comparing().thenComparing()(默认比较器)");
        printPersonInfo(people);

        // 4. Arrays.comparing().thenComparing()
        //  键：姓，比较器：按姓升序，若相同，则按名（提供新的比较器：null优先）升序(自然顺序)
        Arrays.sort(people, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName,
                Comparator.nullsFirst(Comparator.naturalOrder())));
        log.info("4.Arrays.comparing().thenComparing()(指定比较器)");
        printPersonInfo(people);

        // 5. Arrays.comparing().thenComparing()
        // 避免null比较可用nullsFirst和nullsLast适配器
        //  nullsFirst，nullsLast方法需要一个比较器，而naturalOrder可为任何实现了Comparator的类建立比较器
        //    reverseOrder:自然顺序的逆序
        //      naturalOrder()    <--> naturalOrder().reversed()
        Arrays.sort(people, Comparator.comparing(Person::getDescription,
                Comparator.nullsLast(Comparator.reverseOrder())));
        log.info("5.nullsLast and reversed order(指定比较器)");
        printPersonInfo(people);

        // 6. Comparator.comparingInt
        Arrays.sort(people, Comparator.comparing(Person::getDescription,
                (s, t) -> Integer.compare((s == null) ? 0 : s.length(), (t == null) ? 0 : t.length())));
        // 避免int，long，double的装箱操作
        Arrays.sort(people,Comparator.comparingInt(p -> p.getDescription().length()));
        log.info("6.comparingInt");
        printPersonInfo(people);
    }

    public static void printPersonInfo(Person[] people) {
        // List才能使用foreach
        for (Person p : people) {
            log.info(p.getDescription());
        }
    }
}
