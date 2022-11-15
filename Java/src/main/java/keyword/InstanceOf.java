package keyword;

import abstclass.Person;
import occupation.Employee;
import occupation.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * boolean result = obj instanceof Class:
 * obj:必须为引用类型或空类型null
 * Class:表示一个类或者一个接口
 * 判断结果:当obj为Class对象，或者是其直接或间接子类，或者是其接口的实现类，则返回true，否则返回false
 * 编译器会检查 obj 是否能转换成右边的class类型，如果不能转换则直接报错，如果不能确定类型，则通过编译，具体看运行时检查。
 * https://www.cnblogs.com/ysocean/p/8486500.html
 * @author moku
 */
public class InstanceOf {

    public static void main(String[] args) {
        // 1. obj必须为引用类型：编译器会检查 obj 是否能转换成右边的class类型
        int i = 0;
//        System.out.println("obj必须为引用类型:" + (i instanceof Integer));

        // 2. obj为null，返回false
        // false
        System.out.println("null类型可称为任意类型的引用类型:" + (null instanceof Integer));
        // false
        System.out.println("null类型可称为任意类型的引用类型:" + (null instanceof Object));

        // 3. obj为class类实例
        Integer integer = 1;
        // true
        System.out.println("obj为class类实例?:" + (integer instanceof Integer));

        // 4. obj为接口实现类
        ArrayList arrayList = new ArrayList();
        List list = new ArrayList();
        // true
        System.out.println("obj为接口实现类?:" + (arrayList instanceof List));
        // true
        System.out.println("obj为接口实现类?:" + (list instanceof List));
        // true(强制类型转换，实际类型为ArrayList)
        System.out.println("obj为接口实现类?:" + (list instanceof ArrayList));

        // 5. obj为class的直接或间接子类
        Person p1 = new Employee();
        Person p2 = new Manager("test");
        Employee p3 = new Employee();
        // true
        System.out.println("obj为class的直接或间接子类?:" + (p1 instanceof Employee));
        // true
        System.out.println("obj为class的直接或间接子类?:" + (p2 instanceof Employee));
        // true
        System.out.println("obj为class的直接或间接子类?:" + (p3 instanceof Employee));
        // false
        System.out.println("obj为class的直接或间接子类?:" + (p3 instanceof Manager));
        // true
        System.out.println("obj为class的直接或间接子类?:" + (p3 instanceof Person));

        // compile-time error:类型转换错误
        // 规则：如果将第一个操作数转换为第二个操作数的类型将始终抛出ClassCastException，则编译器不允许在这些操作数上应用instanceof运算符
        // 此处Employee实例永远不能是java.lang.String的实例
//        System.out.println(p3 instanceof String);
        // false
        System.out.println(p3 instanceof List);
        // false
        System.out.println(p3 instanceof List<?>);
        // 编译器类型转换错误
//        System.out.println(p3 instanceof List<Person>);//编译报错
    }

}
