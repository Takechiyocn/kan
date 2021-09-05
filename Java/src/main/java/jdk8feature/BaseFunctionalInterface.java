package jdk8feature;

import org.apache.commons.lang3.StringUtils;
import superclass.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author moku
 */
public class BaseFunctionalInterface {
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
     * 函数式接口Function：转换一个用户
     * 接口第二个参数表明返回值类型
     */
    public Person transformPerson(Person user, Function<Person, Person> userFunction) {
        return userFunction.apply(user);
    }

    /**
     * 断言式接口Predicate：检验用户是否合法
     */
    public boolean checkPerson(Person user, Predicate<Person> userPredicate) {
        return userPredicate.test(user);
    }

    public static void main(String[] args) {
        // 匿名内部类
        Person user1 = new Person() {{
            this.setName("user1");
            this.setAge(22);
        }};

        // 测试Consumer
        BaseFunctionalInterface mainIns = new BaseFunctionalInterface();
        mainIns.print(user1, user -> System.out.println(user));

        // 测试Supplier
        final Person user2 = mainIns.getPerson(() -> {
            return new Person() {{
                this.setName("user2");
                this.setAge(32);
            }};
        });
        System.out.println(user2);

        // 测试Function
        final Person user3 = mainIns.transformPerson(user1, (userIn) -> {
            userIn.setName("user11");
            userIn.setAge(23);
            return userIn;
        });
        System.out.println(user3);

        // 测试Predicate
        final boolean checkPerson = mainIns.checkPerson(user1, user -> StringUtils.isNotBlank(user.getName()));
        System.out.println(checkPerson);

        // 定义函数式实现变量
        Predicate<String> str = (s) -> StringUtils.isNotBlank(s);
        System.out.println(str.test("aa"));
        // 抽象方法合并
        // a(test)::equals
        System.out.println(Predicate.isEqual("test").test("test"));
        // x(test2) -> a.equals(x) || x -> b.equals(x)
        System.out.println(Predicate.isEqual("test").or(Predicate.isEqual("test2")).test("test2"));
        // x(test3) -> a.equals(x) && x -> b.equals(x)
        System.out.println(Predicate.isEqual("test").and(Predicate.isEqual("test2")).test("test3"));
    }
}


