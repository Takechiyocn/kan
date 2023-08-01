package logic.designstructure.behavior.b6memento;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/25 1:58
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        Player player = new Player();
        // 初始存档
        Memento memento = player.saveState();
        System.out.println("初始，状态：[生命=" + player.getLife()
                + ", 蓝条=" + player.getMagic() + "]");

        // 打Boss
        player.fightBoss();
        System.out.println("打Boss后，状态：[生命=" + player.getLife()
                + ", 蓝条=" + player.getMagic() + "]");

        // 恢复存档
        player.restoreState(memento);
        System.out.println("恢复存档后，状态：[生命=" + player.getLife()
                + ", 蓝条=" + player.getMagic() + "]");
    }
}
