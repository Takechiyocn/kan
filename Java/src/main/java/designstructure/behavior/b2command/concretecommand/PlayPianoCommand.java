package designstructure.behavior.b2command.concretecommand;

import designstructure.behavior.b2command.Command;
import designstructure.behavior.b2command.receiver.DogRobotReceiver;

/**
 * @ClassName PlayPianoCommand
 * @Description
 * @Author moku
 * @Date 2022/12/24 21:35
 * @Version 1.0
 */
public class PlayPianoCommand implements Command {
    private DogRobotReceiver dogRobot;

    public PlayPianoCommand(DogRobotReceiver dogRobot) {
        this.dogRobot = dogRobot;
    }

    @Override
    public void execute() {
        dogRobot.playPiano();
    }
}
