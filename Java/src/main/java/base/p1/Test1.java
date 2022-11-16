package base.p1;

import base.p11.Son11;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author moku
 * @Date 2022/11/16 23:40
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        // 同包：子类实例可访问
        son1.f(); // Compile OK ----（1）
        // Son1类中可访问clone方法
//        son1.clone(); // Compile Error ----（2）

        Son11 son11 = new Son11();
        // 同包：子类实例可访问
        son11.f(); // Compile OK ----（3）
        // Son11类中可访问clone方法
//        son11.clone(); // Compile Error ----（4）
    }
}
