package innerclass;

import javax.swing.*;

/**
 * @description:
 * @author: Kan
 * @date: 2021/3/4 23:05
 */
public class AnonymousLocalClassByLambdaTest {
    public static void main(String[] args) {
        AnonymousLocalClassByLambda clock = new AnonymousLocalClassByLambda();
        clock.start(5000, true);

        JOptionPane.showConfirmDialog(null, "Quit???");
    }
}
