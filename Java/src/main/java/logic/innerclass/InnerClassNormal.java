package logic.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description: 普通内部类、动态内部类？
 * @author: Kan
 * @date: 2021/3/3 21:27
 */
public class InnerClassNormal {
    // 外围类域类型：没有限制
    private static int interval;
    private static boolean beep;
    private static final String name = "moku";
    private String subname = "kan";

    public InnerClassNormal(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        // 1.内部类调用方式：简写
//        ActionListener actionListener = new TimerPrinter();
        // 2.内部类调用方式：全写
        // this：类实例(调用元该对象)，即内部类实例化为：
        //    A：外部类
        //    B：内部类
        //    实例化B： A.B b = new A().new B();
        ActionListener actionListener = this.new TimerPrinter();
        new Timer(interval, actionListener).start();
    }

    /**
     * 内部类
     */
    public class TimerPrinter implements ActionListener {

        // 内部类域成员不能为静态：如果定义相同，则内部域成员覆盖外部类域成员定义
        // 可以为内部类声明静态常量(static final)
        private static final String NAME = "[inner definition]";
        private static final int AGE = 10;
        public static final char CHAR_TEST= 'c';
        // 静态常量编译时确定值，而new只有在运行时堆中开辟空间创建对象。
//        private static final String STR_TEST = new String("aa");
//        private static final Person PERSON_TEST = new Person("user",12);
//        private static String name0 = "moku2";
        private static final String name2 = "moku2";
        private String subname2 = "kan2";

        @Override
        public void actionPerformed(ActionEvent e) {
            final String name3 = "moku3";

            System.out.println("At the one, the time is " + new Date() + ", Name outer:" + name  + ", Name inner:" + NAME + ",Subname:" +subname);
            // 静态方法没有this，所以不能用this.getClass()
            // new Object(){}:建立Object的一个匿名子类的匿名对象
            // getEnclosingClass:得到起外围类，也就是包含这个静态方法的类
            System.out.println("Inner class:" + new Object(){}.getClass().getEnclosingClass() + ", Name2:" + name2 + ",Subname2:" +subname2);

            // 外围类对象域：生命周期直到对象销毁
            if (beep) {
            // 类名.**：访问静态域，不能直接访问非静态域
//            if (InnerClassNormal.beep) {
            // 类名.this.**：访问非静态域，访问静态域产生编译警告
//            if (InnerClassNormal.this.beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public static void main(String[] args) {
        InnerClassNormal icn = new InnerClassNormal(2000,true);
        icn.start();

        JOptionPane.showConfirmDialog(null,"Quit?");
        System.exit(0);
    }
}
