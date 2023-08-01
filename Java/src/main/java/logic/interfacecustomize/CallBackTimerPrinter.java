package logic.interfacecustomize;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description:
 * @author: Kan
 * @date: 2021/2/27 23:52
 */
@Slf4j
public class CallBackTimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
