package concept;

import common.ConstantsBase;

import java.util.ArrayList;

/**
 * @Description: 常量类 不能被继承
 * 分类：
 *   编译时常量
 *   运行时常量
 * 特点：
 *   常量类（final修饰类名）：
 *     不能被继承
 *     构造方法不能被final修饰 -> 所有类
 *     常量类里面的方法隐式为常量方法且不能被重写
 *   常量方法（final修饰方法名）：不能被重写
 *   静态常量（static final修饰）：一般以大写字母和下划线命名，是一个不可改变的内存空间（常量池）
 *   常量域（基本类型）：属性值不能被改变，且只能赋值一次 --> 编译时，运行时赋值
 *   常量域（引用类型）：属性引用不能被改变，只能指向一个引用，属性指向的对象里面的值可以改变
 *   常量赋值：
 *     编译时常量：编译时初始化时赋值
 *     运行时常量：运行时类构造方法里赋值
 *
 *   不可变对象：常量类且对象成员为常量类型，如包装类Long
 *   特点：线程安全
 *        hasCode相同
 *        不可变对象的引用可以被缓存
 *      --> 缓存池
 */
public final class Constants {

    // 编译时常量：静态常量，以大写字母加下划线命名，一般对外可见
    public static final int MAX_VALUE = 200;

    // 编译时常量：基本类型，初始化时赋值
    private final int eyes = 2;

    // 编译时常量：引用类型常量，包括类、数组、集合
    private final ConstantsBase constantsBase = new ConstantsBase("david");
    private final int[] intArray = {1,2,3,4,5};
    private final ArrayList<String> list = new ArrayList<>();

    // 运行时常量：基本类型，在构造方法里面赋值
    public final int watches;

    // 构造方法，不能被final修饰，常量可在构造方法中赋值
    public Constants(int watches) {
        // 常量赋值
        this.watches = watches;
        // 引用常量，对象添加值
        list.add("a");
        list.add("b");
    }

    // 常量方法，不能被重写
    public final void change() {
        // 错误引用
        // 引用常量不能再次指向新的引用
        // constantsBase = new ConstantsBase("Tom");
        // intArray = new int[1];
        // list = new ArrayList<>();

        // 正确引用
        // 可改变引用常量里面属性的值
        constantsBase.setName("Jack");
        // 数组操作
        intArray[1] = 22;
        // 集合操作
        list.set(0, "b");
    }
}
