package abstclass;

/**
 * Robot: charge, work
 * People: eat, work, sleep
 * Pig: eat, sleep
 *
 * @author moku
 */
public abstract class Action {

    public static final int EAT = 1;
    public static final int SLEEP = 3;
    public static final int WORK = 5;

    public abstract void eat();

    public abstract void sleep();

    public abstract void work();

    public void command(int flags) {
        switch (flags) {
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT + SLEEP:
                this.eat();
                this.sleep();
                break;
            case EAT + WORK:
                this.sleep();
                this.work();
                break;
            case EAT+ WORK + SLEEP:
                this.eat();
                this.work();
                this.sleep();
                break;
            default:
                break;
        }
    }
}
