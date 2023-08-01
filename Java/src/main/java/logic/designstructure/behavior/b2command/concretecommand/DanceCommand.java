package logic.designstructure.behavior.b2command.concretecommand;

import logic.designstructure.behavior.b2command.Command;
import logic.designstructure.behavior.b2command.receiver.CatRobotReceiver;

/**
 * @ClassName DanceCommand
 * @Description
 * @Author moku
 * @Date 2022/12/24 21:36
 * @Version 1.0
 */
public class DanceCommand implements Command {
    private CatRobotReceiver catRobot;
    private String duration;

    public DanceCommand(CatRobotReceiver catRobot, String duration) {
        this.catRobot = catRobot;
        this.duration = duration;
    }

    @Override
    public void execute() {
        System.out.println(String.format("开始跳舞，时长：%s", duration));
        catRobot.dance();
    }
}
