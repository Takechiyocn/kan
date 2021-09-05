package innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description: 局部类：若内部类只使用一次（创建内部类实例时），则可定义为局部内部类
 *                      局部类的方法只可以引用定义为final的（包含内部类的函数的）局部变量，即一旦赋值就绝不会改变
 * @author: Kan
 * @date: 2021/3/4 22:22
 */
public class TalkingClockLocalClass {
//    private final int interval;
//    private final boolean beep;

//    public TalkingClockLocalClass(int interval, boolean beep) {
//        this.interval = interval;
//        this.beep = beep;
//    }

    /**
     * 局部类：为什么可以局部类可以访问参数变量
     *        -> 因为生命周期不同，start调用后，内部变量会被销毁，就会出现内部类非法引用，但是作用于范围相关(该内部类的作用域就在该方法体内)
     *           因此下列参数应定义为final boolean beep，但JDK1.8后编译器将局部变量默认为final型，因此可以省略final关键字
     * 调用流程：
     *   1.测试类调用start(int, boolean)
     *   2. 调用内部类TimerPrinter的(默认)构造器，以便初始化对象变量listener
     *   3. 讲listener传递给timer构造器，start方法结束。**此时start方法的beep参数变量不复存在
     *   4. 定时间隔(interval)后，actionPerformed方法执行if (beep)
     *   5. TimerPrinter类在beep域释放之前将beep域用start方法的局部变量进行备份。类似： final boolean val$beep;
     *   --> 实际上调用start的时候val$beep数据域已经建立(java按引用传递参数)并讲局部变量拷贝到该数据域，
     *       当创建TimerPrinter对象时候，将该局部变量拷贝到构造其中。因此局部变量(参数变量)与拷贝保持一致。
     *
     * @param interval
     * @param beep
     */
    public void start(int interval, boolean beep) {
        class TimerPrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the one, the time is " + new Date());
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener actionListener = new TimerPrinter();
        new Timer(interval, actionListener).start();
    }
}
