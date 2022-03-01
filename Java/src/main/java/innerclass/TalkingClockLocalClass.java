package innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description: 局部类：若内部类只使用一次（创建内部类实例时），则可定义为局部内部类
 *                      局部类的方法只可以引用定义为final的（包含内部类的函数的）局部变量，即一旦赋值就绝不会改变
 *                      --> 针对内部类及内部类的方法参数而言。对于外围类或内部类域成员，则没有此限制
 * @author: Kan
 * @date: 2021/3/4 22:22
 */
public class TalkingClockLocalClass {
    // 外围类域类型：没有限制
    private static int interval;
    private boolean beep;
    private static final String name = "moku";
    private String subname = "kan";

    public TalkingClockLocalClass(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public TalkingClockLocalClass() {
        this.interval = 1000;
        this.beep = false;
    }

    /**
     * 局部类：为什么可以局部类可以访问参数变量
     *        -> 由于生命周期不同，start调用后，内部变量会被销毁，就会出现内部类非法引用，但是作用域范围相关(该内部类的作用域就在该方法体内)
     *           因此下列参数应定义为final boolean beep(因为不是包装类型，java按引用传递，不能改变引用指向，可改变引用指向的地址存放的值)，
     *           但JDK1.8后编译器将局部变量默认为final型，因此可以省略final关键字

     * 调用流程：
     *   1.测试类调用start(int, boolean)
     *   2. 调用内部类TimerPrinter的(默认)构造器，以便初始化对象变量listener
     *   3. 将listener传递给timer构造器，start方法结束。**此时start方法的beep参数变量不复存在
     *   4. 定时间隔(interval)后，actionPerformed方法执行if (beep)
     *   5. TimerPrinter类在beep域释放之前将beep域用start方法的局部变量进行备份。类似： final boolean val$beep;
     *   --> 实际上调用start的时候val$beep数据域已经建立(java按引用传递参数)并将局部变量拷贝到该数据域，
     *       当创建TimerPrinter对象时候，将该局部变量拷贝到构造其中。因此局部变量(参数变量)与拷贝保持一致。
     *
     * @param interval
     * @param beep
     */
    public void start(int interval, boolean beep) {

        class TimerPrinter implements ActionListener {

            // 内部类域成员不能为静态
            // 可以为内部类声明静态常量(static final)
            private static final String NAME = "aa";
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
                System.out.println("[innerLocalClassAccessByPara]At the one, the time is " + new Date() + ", Name:" + name + ",Subname:" +subname);
                System.out.println("[innerLocalClassAccessByPara]Name2:" + name2 + ",Subname2:" +subname2);
                // start方法销毁后，final类型的beep作用域并未消失，还在内存中
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        // 参数变量生命周期：该方法结束，即start()方法调用后
        // 所以编译器有：将参数变量beep拷贝到TimerPrinter构造器中的操作
        ActionListener actionListener = new TimerPrinter();
        new Timer(interval, actionListener).start();
    }

    public void start() {
        class TimerPrinter implements ActionListener {

            // 内部类域成员不能为静态
            // 可以为内部类声明静态常量(static final)
            private static final String NAME = "aa";
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
                System.out.println("[innerLocalClassAccessByField]At the one, the time is " + new Date() + ", Name:" + name + ", Subname:" +subname);
                System.out.println("[innerLocalClassAccessByField]Name2:" + name2 + ", Subname2:" +subname2);
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        // 外围类对象域：生命周期直到外围类对象销毁
        ActionListener actionListener = new TimerPrinter();
        new Timer(interval, actionListener).start();
    }
}
