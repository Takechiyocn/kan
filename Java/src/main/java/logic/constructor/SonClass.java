package logic.constructor;

/**
 * 子类必须实现对父类构造器的显式或隐式调用
 *   a. 父类构造器默认  -> 可显式，隐式调用（编译器）
 *   b. 父类构造器自定义 -> super显式调用
 * 所谓继承：必须继承父类的域(不论有无)，通过super构造器继承
 */
public class SonClass extends FatherClass {

    // case1：父类有默认的构造方法或自定义构造方法与默认构造方法相同
    //        1. 子类不定义构造方法
    //          -> 隐式调用父类默认构造方法
    //        2. 子类自定义构造方法
    //          -> 显示或隐式(编译器)调用父类默认构造方法

    // 子类自定义构造方法
    public SonClass() {
        // 编译器可以隐式调用父类默认构造方法
        super();
        System.out.println("Son class constructor with parameter.");
    }

    // case2：父类没有默认的构造方法，父类自定义构造方法
    //        a. 子类必须显示调用父类自定义构造方法
//    public SonClass() {
//        super("test");
//    }


    public static void main(String[] args) {
        SonClass sonClass = new SonClass();
    }
}
