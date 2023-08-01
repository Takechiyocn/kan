package abstclass;

import logic.abstclass.Action;

public class ActionTest {

    public static void main(String args[]) {

        func(new Robot());
        func(new People());
        func(new Pig());
    }

    private static void func(Action action) {
        action.sleep();
        action.eat();
        action.work();
    }
}
