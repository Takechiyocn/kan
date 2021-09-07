package jdk8feature.methodref;

import java.util.function.BiPredicate;

/**
 * 类型               语法                  对应的Lambda表达式
 * 静态方法引用        类名::staticMethod    (args) -> 类名.staticMethod(args)
 * 实例方法引用        inst::instMethod      (args) -> inst.instMethod(args)  --> 必须实例化
 * 对象方法引用        类名::instMethod      (inst,args) -> inst.instMethod(args)
 * 构建方法引用        类名::new             (args) -> new 类名(args)
 * @author moku
 */
public class MethodReference3ObjectMethod {

    public static void main(String[] args) {

        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        boolean test = bp.test("a", "b");
        System.out.println("lambda方法引用：" + test);

        // 若lambda参数列表中的第一个参数是实例方法(equals)的参数调用者，
        // 而第二个参数是实例方法的参数时，可使用对象方法引用
        BiPredicate<String,String> bp1 = String::equals;
        boolean test2 = bp.test("a","b");
        System.out.println("对象方法引用："+ test2);
    }
}
