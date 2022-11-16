package base.p22;

import base.p2.MyObject2;

/**
 * @ClassName Test2
 * @Description protected：包和子类
 *   1. 子类中可以直接访问protected方法/成员
 *   2. 调用包和protected方法/成员：
 *       同包：子类实例可访问
 *       不同包：子类实例只能访问继承来的protected方法/成员
 * @Author moku
 * @Date 2022/11/17 0:18
 * @Version 1.0
 */
public class Test2 extends MyObject2 {
    public static void main(String args[]) throws CloneNotSupportedException {
        MyObject2 obj = new MyObject2();
        // 在子类中的超类实例无法访问protected方法/成员
//        obj.clone(); // Compile Error ----（1）

        Test2 tobj = new Test2();
        // 调用包和protected方法/成员：不同包：子类实例只能访问继承来的protected方法/成员
        tobj.clone(); // Complie OK ----（2）
    }

    /*
    //示例三
    package p3;
    class MyObject3 extends Test3 {
    }

    package p33;
    public class Test3 {
      public static void main(String args[]) {
        MyObject3 obj = new MyObject3();
        // 调用包和protected方法/成员：不同包：子类实例只能访问继承来的protected方法/成员
        // 此处为Test3继承的Object.clone方法
        obj.clone(); // Compile OK ------（1）
      }
    }
     */

    /*
    //示例四
    package p4;
    class MyObject4 extends Test4 {
      protected Object clone() throws CloneNotSupportedException {
        return super.clone();
      }
    }

    package p44;
    public class Test4 {
      public static void main(String args[]) {
        MyObject4 obj = new MyObject4();
        // 此处clone()方法是子类自身的方法了，来源于MyObject4本身，
        // 作为超类是没有权限访问子类的protected成员的
        obj.clone(); // Compile Error -----（1）
      }
    }
     */
}
