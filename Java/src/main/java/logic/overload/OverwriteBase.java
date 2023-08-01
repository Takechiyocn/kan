package logic.overload;

/**
 * @ClassName Overwrite
 * @Description 多态中，子类重写的方法，当super调用就是调用父类方法。
 * @Author moku
 * @Date 2023/2/5 14:17
 * @Version 1.0
 */
public class OverwriteBase {
    public void methodOne() {
        System.out.print("A");
        // 未被super调用，使用当前正在调用这个方法(methodOne)的对象b
        // 等价于this.methodTwo
        methodTwo();
    }

    public void methodTwo() {
        System.out.print("B");
    }
}

class Derived extends OverwriteBase {
    public void methodOne() {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo() {
        super.methodTwo();
        System.out.print("D");
    }

    public static void main(String[] args) {
        OverwriteBase b = new Derived();
        b.methodOne();
    }
}
