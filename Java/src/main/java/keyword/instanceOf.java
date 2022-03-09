package keyword;

import abstclass.Person;
import occupation.Employee;
import occupation.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * boolean result = obj instanceof Class:
 * obj:为一个对象
 * Class:表示一个类或者一个接口
 * 判断结果:当obj为Class对象，或者是其直接或间接子类，或者是其接口的实现类，则返回true，否则返回false
 * 编译器会检查 obj 是否能转换成右边的class类型，如果不能转换则直接报错，如果不能确定类型，则通过编译，具体看运行时定。
 * https://www.cnblogs.com/ysocean/p/8486500.html
 */
public class instanceOf {



    public static void main(String[] args) {
        // 1. obj必须为引用类型：编译器会检查 obj 是否能转换成右边的class类型
        int i = 0;
//        System.out.println("obj必须为引用类型:" + (i instanceof Integer));

        // 2. obj为null，返回false
        System.out.println("null类型可称为任意类型的引用类型:" + (null instanceof Integer));
        System.out.println("null类型可称为任意类型的引用类型:" + (null instanceof Object));

        // 3. obj为class类实例
        Integer integer = 1;
        System.out.println("obj为class类实例:" + (integer instanceof Integer));

        // 4. obj为接口实现类
        ArrayList arrayList = new ArrayList();
        List list = new ArrayList();
        System.out.println("obj为接口实现类:" + (arrayList instanceof List));
        System.out.println("obj为接口实现类:" + (list instanceof List));
        System.out.println("obj为接口实现类:" + (list instanceof ArrayList));

        // 5. obj为class的直接或间接子类
        Person p1 = new Employee();
        Person p2 = new Manager("test");
        Employee p3 = new Employee();
        System.out.println("obj为class的直接或间接子类:" + (p1 instanceof Employee));
        System.out.println("obj为class的直接或间接子类:" + (p2 instanceof Employee));
        System.out.println("obj为class的直接或间接子类:" + (p3 instanceof Employee));
        System.out.println("obj为class的直接或间接子类:" + (p3 instanceof Manager));
        System.out.println("obj为class的直接或间接子类:" + (p3 instanceof Person));

//        System.out.println(p3 instanceof String);//编译报错
        System.out.println(p3 instanceof List);//false
        System.out.println(p3 instanceof List<?>);//false
//        System.out.println(p3 instanceof List<Person>);//编译报错
    }

}
