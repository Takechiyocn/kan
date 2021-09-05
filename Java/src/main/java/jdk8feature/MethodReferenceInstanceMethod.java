package jdk8feature;

import superclass.ActionEventLocal;
import superclass.Person;

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
public class MethodReferenceInstanceMethod extends ActionEventLocal {

    // 子类含有默认构造方法，父类没有默认构造方法会报错
//    public MethodReferenceInstanceMethod() {
//        super("aa",11);
//    }

    public static void main(String[] args) {
        Person person = new Person("user1", 22);
        Supplier<String> supplier1 = () -> person.getName();
        System.out.println("Lambda表达式：" + supplier1.get());

        // 类(Person)要先实例化(person)
        Supplier<String> supplier2 = person::getName;
        System.out.println("实例方法引用：" + supplier2.get());

        MethodReferenceInstanceMethod mainIns = new MethodReferenceInstanceMethod();
        mainIns.greet();
    }

    public void greet() {
//        Timer t = new Timer(10000, e->System.out.println(e));
//        Timer t2 = new Timer(5000, e -> super.greet(e));
        // ActionListener必须要有监听对象（ActionEvent），所有super的greet方法必须有该参数
        Timer t = new Timer(2000, super::greet);
        t.start();
        JOptionPane.showConfirmDialog(null, "Quit?");
    }
}
