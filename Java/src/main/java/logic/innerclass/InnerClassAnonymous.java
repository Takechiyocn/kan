package logic.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description: 匿名内部类:若内部类只使用一次（创建内部类实例时）
 * @author: Kan
 * @date: 2021/3/4 22:49
 */
public class InnerClassAnonymous {
    // 外围类域类型：没有限制
    private static int interval;
    private boolean beep;
    private static final String name = "moku";
    private String subname = "kan";

    public void start(int interval, boolean beep) {

        ActionListener listener = new ActionListener() {
            // 内部类域成员不能为静态
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
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the one, the time is " + new Date() + ", Name outer:" + name + ", Name inner:" + NAME  + ", Subname:" +subname);
                System.out.println("Name2:" + name2 + ", Subname2:" +subname2);
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        new Timer(interval, listener).start();
    }

    public static void main(String[] args) {
        InnerClassAnonymous ica = new InnerClassAnonymous();
        ica.start(2000, true);

        JOptionPane.showConfirmDialog(null, "Quit??");
    }
}
