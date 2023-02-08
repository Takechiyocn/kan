package designstructure.creational.factory3abstractfactory.factory;

import designstructure.creational.factory3abstractfactory.absclazz.Computer;
import designstructure.creational.factory3abstractfactory.macimplement.MacComputer;
import designstructure.creational.factory3abstractfactory.absclazz.IPhone;
import designstructure.creational.factory3abstractfactory.phoneimplement.MobilePhone;

/**
 * @ClassName AppleFactory
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:36
 * @Version 1.0
 */
public class AppleFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }

    @Override
    public MobilePhone makeMobilePhone() {
        return new IPhone();
    }
}
