package abstclass;

import logic.abstclass.Action;

public class Pig extends Action {
    @Override
    public void eat() {
        System.out.println("Pig eat.");
    }

    @Override
    public void sleep() {
        System.out.println("Pig sleep.");
    }

    @Override
    public void work() {

    }
}
