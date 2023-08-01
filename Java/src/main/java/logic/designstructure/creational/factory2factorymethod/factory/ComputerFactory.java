package logic.designstructure.creational.factory2factorymethod.factory;

import logic.designstructure.creational.factory2factorymethod.absclazz.Computer;

/**
 * @ClassName AbstractComputerFactory
 * @Description 3.定义工厂接口
 * @Author moku
 * @Date 2022/12/18 19:23
 * @Version 1.0
 */
public interface ComputerFactory {
    Computer makeComputer();
}
