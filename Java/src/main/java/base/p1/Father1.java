package base.p1;

/**
 * @ClassName Father1
 * @Description protected：包和子类
 *   1. 子类中可以直接访问protected方法/成员
 *   2. 调用包和protected方法/成员：
 *       同包：子类实例可访问
 *       不同包：子类实例只能访问继承来的protected方法/成员
 * @Author moku
 * @Date 2022/11/16 23:38
 * @Version 1.0
 */
public class Father1 {

    // 父类protected成员
    protected String str = "A";

    // 父类protected方法
    protected void f() {
    }
}
