package logic.designstructure.behavior.b6memento;

/**
 * @ClassName Player
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:55
 * @Version 1.0
 */
public class Player {
    private int life = 100;
    private int magic = 100;

    public void fightBoss() {
        life -= 100;
        magic -= 100;
        if (life <= 0) {
            System.out.println("You lose...");
        }
    }

    public int getLife() {
        return life;
    }

    public int getMagic() {
        return magic;
    }

    // 存档
    public Memento saveState() {
        return new Memento(life, magic);
    }

    // 读档
    public void restoreState(Memento memento) {
        this.life = memento.life;
        this.magic = memento.magic;
    }
}
