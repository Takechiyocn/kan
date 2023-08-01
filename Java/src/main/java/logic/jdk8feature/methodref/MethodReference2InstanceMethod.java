package logic.jdk8feature.methodref;

import logic.superclass.ActionEventLocal;
import logic.superclass.Person;

import javax.swing.*;
import java.util.function.Supplier;

/**
 * 类型               语法                  对应的Lambda表达式
 * 静态方法引用        类名::staticMethod    (args) -> 类名.staticMethod(args)
 * 实例方法引用        inst::instMethod      (args) -> inst.instMethod(args)  --> 必须实例化,可用this、supper
 * 对象方法引用        类名::instMethod      (inst,args) -> inst.instMethod(args)
 * 构建方法引用        类名::new             (args) -> new 类名(args)
 *
 * @author moku
 */
public class MethodReference2InstanceMethod extends ActionEventLocal {

    public static void main(String[] args) {

        Person person = new Person("user name", 22);
        person.setMessage("msg set OK.");

        // 函数式接口变量
        Supplier<String> supplier1 = () -> person.getName();
        //  -> 未明确说明复写方法get(此处：() -> person.getName())的执行时机，
        //     函数式接口方法的执行时机应显示调用
        //     -> 为什么要执行时机，如果函数式接口的方法不被调用，实现该函数式接口会没有意义
        System.out.println("供给型函数式接口变量：" + supplier1.get());

        // 类(Person)要先实例化(person)
        Supplier<String> supplier2 = person::getName;
        System.out.println("实例方法引用：" + supplier2.get());

        //
        MethodReference2InstanceMethod mainIns = new MethodReference2InstanceMethod();
        mainIns.greet(person);
    }

    /**
     * 自定义实例方法调用
     * @param person
     */
    public void greet(Person person) {

        Timer t = new Timer(10000, e -> System.out.println(e));
        Timer t2 = new Timer(5000, (e) -> super.greet(e));
        Timer t3 = new Timer(5000, (e) -> super.greet2(person::getMessage,e));


        // 方法引用时，谁调用谁负责参数的传递：此处Timer到时后发送一个信号给注册到Timer的监听器listener:System.out::println
        // 实例方法引用
        Timer tt = new Timer(10000, System.out::println);

        // ActionListener接口的抽象方法必须复写，即下列方法必须实现（带有参数）
        // super的greet方法必须有该参数
        //   public void actionPerformed(ActionEvent e);
        Timer tt2 = new Timer(2000, super::greet);
        tt2.start();

        // TODO: 实例方法引用带有参数，无法实现：方法引用参数由调用者隐式传递给方法
//        Timer tt3 = new Timer(2000, super::greet2);

        t3.start();

        JOptionPane.showConfirmDialog(null, "Quit?");
    }
}
