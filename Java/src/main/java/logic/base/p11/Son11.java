package logic.base.p11;

import logic.base.p1.Father1;

/**
 * @ClassName Son11
 * @Description TODO
 * @Author moku
 * @Date 2022/11/16 23:39
 * @Version 1.0
 */
public class Son11 extends Father1 {

    // 子类(不同包)可访问protected方法
    void test() throws CloneNotSupportedException {
        // 子类直接访问protected方法
        f();
        // 子类直接访问protected成员
        String strSon11 = str;

        Son11 son11 = new Son11();
        // Object子类(此处Son11)可访问Object.clone方法
        son11.clone();
    }
}
