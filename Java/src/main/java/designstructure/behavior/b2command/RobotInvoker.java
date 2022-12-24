package designstructure.behavior.b2command;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RobotInvoker
 * @Description 设置命令集
 * @Author moku
 * @Date 2022/12/24 21:40
 * @Version 1.0
 */
public class RobotInvoker {
    private final List<Command> robotCommands = new ArrayList<>();

    // 清空命令
    public void clearCommand() {
        robotCommands.clear();
    }

    // 设置命令集
    public void addCommands(Command command) {
        robotCommands.add(command);
    }

    // 执行命令
    public void executeCommand(){
        for (Command c : robotCommands) {
            c.execute();
        }
    }
}
