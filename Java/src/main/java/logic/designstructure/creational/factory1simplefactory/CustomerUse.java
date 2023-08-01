package logic.designstructure.creational.factory1simplefactory;

import logic.designstructure.creational.factory1simplefactory.absclazz.Computer;
import logic.designstructure.creational.factory1simplefactory.factory.SimpleComputerFactory;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/18 19:26
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        SimpleComputerFactory factory = new SimpleComputerFactory();
        // 生产mac电脑
        Computer mac = factory.makeComputer("mac");
        mac.setOperationSystem();
        // 生产小米电脑
        Computer mi = factory.makeComputer("mi");
        mi.setOperationSystem();
    }
}
