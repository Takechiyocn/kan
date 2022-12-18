package designstructure.creational.factory3abstractfactory.macfactory;

/**
 * @ClassName MacComputer
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:29
 * @Version 1.0
 */
public class MacComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("Mac笔记本安装Mac系统");
    }
}
