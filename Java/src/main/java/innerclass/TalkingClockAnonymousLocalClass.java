package innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 22:49
 */
public class TalkingClockAnonymousLocalClass {
    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Anonymous local class: " + new Date());
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        new Timer(interval, listener).start();
    }
}
