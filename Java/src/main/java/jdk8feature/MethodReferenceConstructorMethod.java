package jdk8feature;

import lombok.extern.slf4j.Slf4j;
import occupation.Employee;
import superclass.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类型               语法                  对应的Lambda表达式
 * 静态方法引用        类名::staticMethod    (args) -> 类名.staticMethod(args)
 * 实例方法引用        inst::instMethod      (args) -> inst.instMethod(args)  --> 必须实例化
 * 对象方法引用        类名::instMethod      (inst,args) -> inst.instMethod(args)
 * 构建方法引用        类名::new             (args) -> new 类名(args)
 * @author moku
 */
@Slf4j
public class MethodReferenceConstructorMethod {
    /**
     * 获取空的Person列表：lambda表达式
     */
    Supplier<List<Person>> userSupplier = () -> new ArrayList<>();
    List<Person> user = userSupplier.get();

    /**
     * 获取空的Person列表：构造器方法引用
     */
    Supplier<List<Person>> userSupplier2 = ArrayList<Person>::new;
    List<Person> person2 = userSupplier2.get();

    public  static void main(String[]args) {
        // 将字符串列表转换为Employee对象数组
        ArrayList<String> names = new ArrayList<>(Arrays.asList("EmployeeA","EmployeeB"));
        ArrayList<Double> salary = new ArrayList<>(){{
            add(11.1);
            add(22.2);
            add(12.0);
        }};
        // 构造器引用：编译器自动选择合适的构造器
        // TODO: 流库后再check
        // 1.string构造器
        Stream<Employee> stream = names.stream().map(Employee::new);
        List<Employee> people = stream.collect(Collectors.toList());
        // 2.double构造器
        Stream<Employee> stream2 = salary.stream().map(Employee::new);
        List<Employee> people2 = stream2.collect(Collectors.toList());

        people.forEach(x -> log.info(x.getName()));
        people2.forEach(x -> log.info(String.valueOf(x.getSalary())));

        // 数组构造器
        Stream<Employee> stream3 = names.stream().map(Employee::new);
        Employee[] peopleArrays = stream3.toArray(Employee[]::new);
        for (Employee e : peopleArrays) {
            log.info("Stream to array:" + e.getName());
        }
    }
}
