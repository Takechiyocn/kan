package designstructure.behavior.b2command.concretecommand;

import designstructure.behavior.b2command.Command;
import designstructure.behavior.b2command.receiver.DogRobotReceiver;

/**
 * @ClassName SingSongCommand
 * @Description
 * @Author moku
 * @Date 2022/12/24 21:34
 * @Version 1.0
 */
public class SingSongCommand implements Command {
    private DogRobotReceiver dogRobot;

    public SingSongCommand(DogRobotReceiver dogRobot) {
        this.dogRobot = dogRobot;
    }

    @Override
    public void execute() {
        dogRobot.singSong();
    }
}
