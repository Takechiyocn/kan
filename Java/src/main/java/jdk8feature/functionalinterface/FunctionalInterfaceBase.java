package jdk8feature.functionalinterface;

import org.apache.commons.lang3.StringUtils;
import superclass.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author moku
 */
public class FunctionalInterfaceBase {
    /**
     * 消费型接口Consumer：打印用户信息
     */
    public void print(Person user, Consumer<Person> userConsumer) {
        userConsumer.accept(user);
    }

    /**
     * 供给型接口Supplier：返回一个用户
     */
    public Person getPerson(Supplier<Person> userSupplier) {
        return userSupplier.get();
    }

    /**
     * 函数型接口Function：转换一个用户
     * 接口第一个参数：input类型
     * 接口第二个参数：output类型就，即函数式接口对象返回值类型
     */
    public Person transformPerson(Person user, Function<Person, Person> userFunction) {
        return userFunction.apply(user);
    }

    /**
     * 断言型接口Predicate：检验用户是否合法
     */
    public boolean checkPerson(Person user, Predicate<Person> userPredicate) {
        return userPredicate.test(user);
    }

    public static void main(String[] args) {
        // 匿名内部类？ TODO：匿名函数，对象匿名初始化
        // 第一个{}：匿名标志
        // 第二个{}：块
        Person userIn = new Person() {{
            this.setName("userIn");
            this.setAge(22);
        }};

        // 相等功能
        Person userIn11 = new Person() {
            Person tmp = new Person();
            {
                this.setName("userIn");
                this.setAge(22);
            }
        };

        // 测试消费型接口Consumer
        FunctionalInterfaceBase mainIns = new FunctionalInterfaceBase();
        mainIns.print(userIn, user -> System.out.println("消费型接口：" + user));

        // 测试供给型接口Supplier
        final Person user2 = mainIns.getPerson(() -> {
            return new Person() {{
                this.setName("user2");
                this.setAge(32);
            }};
        });
        System.out.println("供给型接口：" + user2);

        // 测试函数型接口Function
        final Person user3 = mainIns.transformPerson(userIn, (userOut) -> {
            userOut.setName("Transferred name: " + userIn.getName());
            userOut.setAge(userIn.getAge());
            return userOut;
        });
        System.out.println("函数型接口：" + user3);

        // 测试断言型接口Predicate
        final boolean checkPerson = mainIns.checkPerson(userIn, user -> StringUtils.isNotBlank(user.getName()));
        System.out.println("断言型接口："+ checkPerson);

        // ***定义函数式接口变量***
        Predicate<String> stringPredicate = (s) -> StringUtils.isNotBlank(s);
        System.out.println("函数式变量："+ stringPredicate.test("aa"));

        // 抽象方法合并 TODO：
        // a(test)::equals
        System.out.println(Predicate.isEqual("test").test("test"));
        // x(test2) -> a.equals(x) || x -> b.equals(x)
        System.out.println(Predicate.isEqual("test").or(Predicate.isEqual("test2")).test("test2"));
        // x(test3) -> a.equals(x) && x -> b.equals(x)
        System.out.println(Predicate.isEqual("test").and(Predicate.isEqual("test2")).test("test3"));
    }
}


