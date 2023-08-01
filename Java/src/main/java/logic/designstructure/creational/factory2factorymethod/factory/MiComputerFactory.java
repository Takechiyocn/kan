package logic.designstructure.creational.factory2factorymethod.factory;

import logic.designstructure.creational.factory2factorymethod.absclazz.Computer;
import logic.designstructure.creational.factory2factorymethod.implement.MiComputer;

/**
 * @ClassName MiComputerFactory
 * @Description 3.1 定义实现工厂类
 * @Author moku
 * @Date 2022/12/18 20:16
 * @Version 1.0
 */
public class MiComputerFactory implements ComputerFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
}
