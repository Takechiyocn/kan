package designstructure.behavior.b2command;

import designstructure.behavior.b2command.concretecommand.DanceCommand;
import designstructure.behavior.b2command.concretecommand.PlayPianoCommand;
import designstructure.behavior.b2command.concretecommand.SingSongCommand;
import designstructure.behavior.b2command.receiver.CatRobotReceiver;
import designstructure.behavior.b2command.receiver.DogRobotReceiver;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/24 21:43
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        // 控制系统
        RobotInvoker invoker = new RobotInvoker();

        // 生成命令
        DogRobotReceiver dogRobot = new DogRobotReceiver();
        SingSongCommand singSongCommand = new SingSongCommand(dogRobot);
        PlayPianoCommand playPianoCommand = new PlayPianoCommand(dogRobot);
        // 构建执行计划
        invoker.addCommands(singSongCommand);
        invoker.addCommands(playPianoCommand);
        invoker.executeCommand();

        // 生命命令
        CatRobotReceiver catRobot = new CatRobotReceiver();
        DanceCommand danceCommand = new DanceCommand(catRobot, "10");
        // 构建执行计划
        invoker.clearCommand();
        invoker.addCommands(danceCommand);
        invoker.executeCommand();
    }
}
