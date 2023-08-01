package logic.designstructure.creational.factory2factorymethod.factory;

import logic.designstructure.creational.factory2factorymethod.absclazz.Computer;
import logic.designstructure.creational.factory2factorymethod.implement.MacComputer;

/**
 * @ClassName MacComputerFactory
 * @Description 3.1 定义实现工厂类
 * @Author moku
 * @Date 2022/12/18 20:15
 * @Version 1.0
 */
public class MacComputerFactory implements ComputerFactory {
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }
}
