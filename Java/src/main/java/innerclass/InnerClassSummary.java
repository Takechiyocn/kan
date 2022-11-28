package innerclass;

/**
 * 内部类：什么是内部？内部就是我是你的一部分，我了解你，我知道你的全部，没有你就没有我。（所以内部类对象是以外部类对象存在为前提的）
 * 使用场景：
 *  内部类方法可以访问该类定义所在的作用域中的数据，包括私有的数据
 *  java封装？：内部类可以对同一个包中的其他类隐藏起来。(如果类B只服务于A，将B嵌套在A内，代码可读性高，便于维护)
 *  当想要定义一个回调函数且不想编写大量代码时，使用匿名（anonymous）内部类比较便捷。
 *
 *  分类：
 *    a. Oracle推荐使用
 *      1. 普通内部类(推荐？) {@link innerclass.InnerClassNormal}
 *      2. 静态内部类：又称静态嵌套类 {@link innerclass.InnerClassStatic}
 *    b. Oracle不推荐使用(非静态内部类) {@link innerclass.InnerClassStatic}
 *      1. 局部内部类(定义在方法体内)：又称局部类 {@link innerclass.InnerClassLocal}
 *      2. 匿名内部类(定义在初始化赋值)：
 *         a. 常规匿名内部类 {@link innerclass.InnerClassAnonymous}
 *            FunctionalInterface obj = new FunctionalInterface {
 *              // 此处实现可视为一个FunctionalInterface对象
 *              @Override
 *              // 抽象方法实现
 *            }
 *            同匿名数组：int[] intArrayStaticInitialization = new int[]{100, 200, 300};
 *         b. lambda匿名内部类 {@link innerclass.InnerClassAnonymousLambda}
 *            //  此处实现可视为一个FunctionalInterface对象
 *            (抽象方法参数xxx) -> {
 *               // 抽象方法实现
 *            }
 *
 *  内部类和局部(内部)类特点：
 *    1.外围类域成员类型没有限制，内部类域成员不能为静态
 *    2.内部类中声明的所有静态域都必须是final，亦即static final
 *      -> 生命周期不同。原理与局部类相同
 *    3. 内部类不能有static方法和变量
 *      -> 1.静态类型的属性和方法，在类加载的时候就会存在于内存中。
 *         2.要使用某个类的静态属性或方法，那这个类必须要加载到虚拟机中（通常导入该类就可以使用静态属性或方法）
 *         3.内部类并不随外部类一起加载，只有在实例化外部类之后才会加载。
 *         --> 如果外部类没有实例化，亦即内部类还没有加载的时候，这时候调用内部类的静态属性或方法，
 *             由于内部类还没有加载，却试图在内存中创建静态属性和方法，跟2.产生冲突。所以内部类不能有静态属性和方法
 *
 * 内部类与静态内部类(静态嵌套类)区别：
 *  内部类：
 *    1. 内部类中的属性和方法不能声明为静态的。
 *        -> 可以声明为静态常量(非new，new对象要在运行时开辟空间)
 *    2. 内部类实例化：
 *       A：外部类
 *       B：内部类
 *       实例化B： A.B b = new A().new B();
 *    3. 内部类可以引用外部类的静态或者非静态属性及方法
 *    4. 局部类和匿名类只能访问外部类的final局部变量（作用域生命周期不同）
 *  静态内部类：
 *    1. 静态内部类属性和方法可以声明为静态或者非静态的。
 *    2. 静态内部类实例化：
 *       A：外部类
 *       B：内部类
 *       实例化B： A.B b = new A.B();
 *    3. 静态内部类只能引用外部类的静态的属性及方法
 *    4. 接口中声明的内部类自动成为static public类
 *
 * @author moku
 */
public class InnerClassSummary {

}
