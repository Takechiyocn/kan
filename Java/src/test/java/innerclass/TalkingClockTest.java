package innerclass;

import javax.swing.*;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/3 21:36
 */
public class TalkingClockTest {
    public static void main(String[] args) {
        TalkingClock tc = new TalkingClock(2000,true);
        tc.start();

        JOptionPane.showConfirmDialog(null,"Quit?");
        System.exit(0);
    }
}
