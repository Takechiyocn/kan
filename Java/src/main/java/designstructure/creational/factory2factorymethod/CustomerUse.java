package designstructure.creational.factory2factorymethod;

import designstructure.creational.factory2factorymethod.factory.ComputerFactory;
import designstructure.creational.factory2factorymethod.factory.MacComputerFactory;
import designstructure.creational.factory2factorymethod.factory.MiComputerFactory;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/18 19:26
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        // 生产mac电脑
        ComputerFactory macFactory = new MacComputerFactory();
        macFactory.makeComputer().setOperationSystem();

        // 生产小米电脑
        ComputerFactory miFactory = new MiComputerFactory();
        miFactory.makeComputer().setOperationSystem();
    }
}
