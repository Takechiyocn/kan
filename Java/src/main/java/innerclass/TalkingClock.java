package innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/3 21:27
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        // 1.简称
//        ActionListener actionListener = new TimerPrinter();
        // 2.全称
        ActionListener actionListener = this.new TimerPrinter();
        new Timer(interval, actionListener).start();
    }

    /**
     * 内部类
     */
    public class TimerPrinter implements ActionListener {
        // 可以为内部类声明静态常量()
        private static final String NAME = "aa";
        private static final int AGE = 10;
        private static final char CHAR_TEST= 'c';
        // 静态常量编译时确定值，而new只有在运行时堆中开辟空间创建对象。
//        private static final String STR_TEST = new String("aa");
//        private static final Person PERSON_TEST = new Person("user",12);

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the one , the time is " + new Date());
            // 静态方法没有this，所以不能用this.getClass()
            // new Object(){}:建立Object的一个匿名子类的匿名对象
            // getEnclosingClass:得到起外围类，也就是包含这个静态方法的类
            System.out.println("Inner class:" + new Object(){}.getClass().getEnclosingClass());
//            if (beep) {
            // 类名.** 可访问静态域
            // 类名.this.** 可以访问非静态域
            if (TalkingClock.this.beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
