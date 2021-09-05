package innerclass;

import javax.swing.*;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 22:29
 */
public class TalkingClockLocalClassTest {
    public static void main(String[] args) {
        TalkingClockLocalClass clock = new TalkingClockLocalClass();
        clock.start(5000, true);

        JOptionPane.showConfirmDialog(null, "Quit?");
        System.exit(0);
    }
}
