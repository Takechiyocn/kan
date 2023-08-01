package logic.base.p1;

/**
 * @ClassName Son1
 * @Description TODO
 * @Author moku
 * @Date 2022/11/16 23:39
 * @Version 1.0
 */
public class Son1 extends Father1 {

    void test() throws CloneNotSupportedException {
        // 子类中直接访问protected方法
        f();
        // 子类中直接访问protected成员
        String strSon1 = str;

        Son1 son1 = new Son1();
        // Object子类(此处Son1)可访问Object.clone方法
        son1.clone();

    }
}
