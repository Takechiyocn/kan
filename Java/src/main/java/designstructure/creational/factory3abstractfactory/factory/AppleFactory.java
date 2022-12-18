package designstructure.creational.factory3abstractfactory.factory;

import designstructure.creational.factory3abstractfactory.macfactory.Computer;
import designstructure.creational.factory3abstractfactory.macfactory.MacComputer;
import designstructure.creational.factory3abstractfactory.phonefactory.IPhone;
import designstructure.creational.factory3abstractfactory.phonefactory.MobilePhone;

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
