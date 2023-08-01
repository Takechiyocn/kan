package logic.innerclass;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 23:02
 */
public class InnerClassAnonymousLambda {
    public void start(int interval, boolean beep) {
        new Timer(interval, (event -> {
            System.out.println("Anonymous local class by lambda: " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        })).start();
    }

    public static void main(String[] args) {
        InnerClassAnonymousLambda ical = new InnerClassAnonymousLambda();
        ical.start(5000, true);

        JOptionPane.showConfirmDialog(null, "Quit???");
    }
}
