package designstructure.creational.factory1simplefactory.factory;

import designstructure.creational.factory1simplefactory.absclazz.Computer;
import designstructure.creational.factory1simplefactory.implement.MacComputer;
import designstructure.creational.factory1simplefactory.implement.MiComputer;

/**
 * @ClassName SimpleComputerFactory
 * @Description 3.定义简单工厂方法类
 * @Author moku
 * @Date 2022/12/18 19:23
 * @Version 1.0
 */
public class SimpleComputerFactory {
    public Computer makeComputer(String brand) {
        Computer computer = null;
        switch (brand) {
            case "mac":
                computer = new MacComputer();
                break;
            case "mi":
                computer = new MiComputer();
                break;
            default:
                break;
        }
        return computer;
    }
}
