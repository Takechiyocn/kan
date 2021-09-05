package interfacecustomize;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/27 23:51
 */
public class CallBackTimerPrinterTest {
    public static void main(String[] args) {
        ActionListener listener = new CallBackTimerPrinter();
        Timer t = new Timer(5000,listener);
        t.start();

        JOptionPane.showConfirmDialog(null, "Quit program?");
        System.exit(0);
    }
}
