package designstructure.creational.factory3abstractfactory.macfactory;

/**
 * @ClassName MiComputer
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:30
 * @Version 1.0
 */
public class MiComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("小米笔记本安装Win10系统");
    }
}
