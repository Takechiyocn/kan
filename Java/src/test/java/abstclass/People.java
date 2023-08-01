package abstclass;

import logic.abstclass.Action;

public class People extends Action {
    @Override
    public void eat() {
        System.out.println("People eat.");
    }

    @Override
    public void sleep() {
        System.out.println("People sleep.");
    }

    @Override
    public void work() {
        System.out.println("People work.");
    }
}
