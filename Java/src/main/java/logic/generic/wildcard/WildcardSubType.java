package logic.generic.wildcard;

import logic.generic.GenericTypeCommon;
import logic.occupation.Employee;
import logic.occupation.Manager;

import java.io.File;

/**
 * 通配符的子类型限定：允许类型参数变化，类似供给型函数式接口Supplier，只接收(从泛型对象读取)
 * GenericTypeCommon<? extends Employee>:类型参数为Employee的子类，如GenericTypeCommon<Manager></>
 * 子类型限定变量定义时，初始化值已经设置为类型参数的类型变量本类型或其子类型(初始化的目标子类型)，故访问器方法时也只能访问这两种类型
 * 对于类型参数传递：
 *     b. 从参数化类型角度来看，只能传递本类或子类对象，如参数化类型Employee的子类Manager对象
 * 与通配符的超类型限定相反：
 *   a. 安全的访问器方法：访问只能接收只能传递本类或子类对象
 * ***通配符不是类型变量***
 *   用法1： 解除泛型类型参数化对象之间无关联限制，对超类型及其子类型的处理可以共通化
 */
public class WildcardSubType {

    /**
     * Employee信息打印
     * 打印Employee和子类Manager的信息时，由于参数化类型不存在相互关系
     * 故，只有分别创建打印Employee和Manager参数化后的打印方法
     *
     * @param p
     */
    public static void printEmployee(GenericTypeCommon<Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName());
    }

    /**
     * Manager信息打印
     *
     * @param p
     */
    public static void printManager(GenericTypeCommon<Manager> p) {
        Manager first = p.getFirst();
        Manager second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName());
    }

    // T类型未知，该方法不是泛型方法
//    public static void printBuddies(GenericTypeCommon<T extends Employee> p) {}

    /**
     * 通配符类型：允许类型参数变化
     * @param p
     */
    public static void printBuddies(GenericTypeCommon<? extends Employee> p) {
        System.out.println(p.getFirst().getName() + " and " + p.getSecond().getName());
    }

    public static void main(String[] args) {

        // 类型(参数被)参数化后，GenericTypeCommon<Employee>信息打印
        Employee e1 = new Employee("employee1");
        Employee e2 = new Employee("employee2");
        GenericTypeCommon<Employee> gtEmployee = new GenericTypeCommon<>(e1, e2);
        printEmployee(gtEmployee);

        // 类型(参数被)参数化后，GenericTypeCommon<Manager>信息打印
        Manager m1 = new Manager("manager1", 1, 1, 1, 1);
        Manager m2 = new Manager("manager2", 1, 1, 1, 1);
        GenericTypeCommon<Manager> gtManager = new GenericTypeCommon<>(m1, m2);
        // 由于参数化类型不存在相互关系，以下语句编译错误
//        printEmployee(gtManager);
        printManager(gtManager);

        // TODO: GenericTypeConstraint6<E, U>接收多个类型变量来实现打印  ->缺点：扩展性差

        /**
         * 为什么要避免泛型类定义而对象使用原始类型(即类是泛型，类对象定义为非泛型对象，即使用原始类型定义类对象)：
         *    原始类型隐藏危险 -> 不安全的更改器方法或不安全的访问器方法
         *  结论：
         *    1. ***** 使用泛型接口时，应该尽量避免使用原始类型 *****
         *    2. 使用泛型接口绑定(不是通配符类型，子类型/超类型限定/绑定)时，应尽量避免使用原型接口(类型擦除后的接口)，应该同时使用类型参数限定
         *       如Comparable<T>接口， 声明方法时， <T extends Comparable<T>> GenericTypeCommon<T> min(Comparable[] a) {} 中的Comparable后的<T>
         */
        GenericTypeCommon<String> minmaxTest = GenericTypeCommon.minmax(new String[] {"Mary","Lily"});
        System.out.println("min测试:string min=" + minmaxTest);
        // 能赋值和设置(setFirst)原因：类型擦除后参数化类型和原始类型均为Object类型，因此可以转换
        //   -> 永远可以将*****参数化类型(如GenericTypeCommon<String>)*****转换为一个原始类型GenericTypeCommon
        GenericTypeCommon rawString = minmaxTest;
        // 不安全的更改器方法(堆污染)
        rawString.setFirst(new File("logic/test"));
        // 运行时错误：类型转换错误ClassCastException
//        String other = (String)rawString.getFirst();

        /**
         * 安全的访问器方法测试
         */
        // 通配符类型不会破坏子类型
        // wildcardBuddies类型：GenericTypeCommon<? extends Employee>
        GenericTypeCommon<? extends Employee> wildcardBuddies = gtManager;
        // wildcardBuddies已经初始化为gtManager，即类型变量T为Manager，故以下更改编译错误：类型不一致
//        wildcardBuddies.setFirst(e1);
        // wildcardBuddies已经初始化为gtManager，用相应类型去接收就行：如用Employee接收则产生下转上类型转换
        Employee e3 = wildcardBuddies.getFirst();
        // 对于编译器而言，wildcardBuddies类型为GenericTypeCommon<? extends Employee>，具体类型未知，具体类型得等到执行时候才知道
        Manager m3 = (Manager) wildcardBuddies.getFirst();
        m3.setBonus(1000);
        // 以下运行时类型转换错误
//        Treasurer t3 = (Treasurer) wildcardBuddies.getFirst();
        System.out.println("e3:" + e3.getName());
        System.out.println("m3:" + m3.getName());
//        System.out.println("t3:" +t3.getName());

        // 通配符参数化类型，GenericTypeCommon<Employee>信息打印
        printBuddies(gtEmployee);

        // 通配符参数化类型，GenericTypeCommon<Manager>信息打印
        printBuddies(gtManager);

        // 由于参数化类型不存在相互关系（跟类型绑定有无无关）
        GenericTypeCommon2<Manager> gtManager2 = new GenericTypeCommon2<>(m1, m2);
        // 类型转换错误
//        GenericTypeCommon2<Employee> wildcardBuddies2 = gtManager2;
    }
}

class GenericTypeCommon2<T extends Employee> {
    private T first;
    private T second;

    public GenericTypeCommon2() {
        first = null;
        second = null;
    }

    public GenericTypeCommon2(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}
