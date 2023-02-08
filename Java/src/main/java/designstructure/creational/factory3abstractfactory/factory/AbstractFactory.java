package designstructure.creational.factory3abstractfactory.factory;

import designstructure.creational.factory3abstractfactory.absclazz.Computer;
import designstructure.creational.factory3abstractfactory.phoneimplement.MobilePhone;

/**
 * @ClassName AbstractFactory
 * @Description 抽象工厂接口
 * @Author moku
 * @Date 2022/12/18 20:35
 * @Version 1.0
 */
public interface AbstractFactory {
    Computer makeComputer();
    MobilePhone makeMobilePhone();
}
