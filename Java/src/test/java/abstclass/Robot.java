package abstclass;

import logic.abstclass.Action;

public class Robot extends Action {

    @Override
    public void eat() {
        System.out.println("Robot charge.");
    }

    @Override
    public void sleep() {

    }

    @Override
    public void work() {
        System.out.println("Robot work.");
    }
}
