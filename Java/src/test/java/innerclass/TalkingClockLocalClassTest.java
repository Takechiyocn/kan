package innerclass;

import javax.swing.*;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 22:29
 */
public class TalkingClockLocalClassTest {
    public static void main(String[] args) {

        // 内部局部类1：访问外围类（包含类）域
//        innerLocalClassAccessByField();

        // 内部局部类2：参数变量
        innerLocalClassAccessByPara();
    }

    /**
     * 内部局部类2：参数变量
     */
    private static void innerLocalClassAccessByPara() {
        TalkingClockLocalClass clock = new TalkingClockLocalClass();
        clock.start(2000, true);

        JOptionPane.showConfirmDialog(null, "Quit?");
        System.exit(0);
    }

    /**
     * 内部局部类1：访问外围类（包含类）成员
     */
    private static void innerLocalClassAccessByField() {
        TalkingClockLocalClass clock = new TalkingClockLocalClass(2000, true);
        clock.start();

        JOptionPane.showConfirmDialog(null, "Quit?");
        System.exit(0);
    }

}
