package innerclass;

import javax.swing.*;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 22:55
 */
public class TalkingClockAnonymousLocalClassTest {
    public static void main(String[] args) {

        TalkingClockAnonymousLocalClass clock = new TalkingClockAnonymousLocalClass();
        clock.start(2000, true);

        JOptionPane.showConfirmDialog(null, "Quit??");
    }
}
