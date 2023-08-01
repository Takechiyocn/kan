package logic.designstructure.creational.factory3abstractfactory.factory;

import logic.designstructure.creational.factory3abstractfactory.absclazz.Computer;
import logic.designstructure.creational.factory3abstractfactory.macimplement.MiComputer;
import logic.designstructure.creational.factory3abstractfactory.phoneimplement.MiPhone;
import logic.designstructure.creational.factory3abstractfactory.phoneimplement.MobilePhone;

/**
 * @ClassName MiFactory
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:37
 * @Version 1.0
 */
public class MiFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }

    @Override
    public MobilePhone makeMobilePhone() {
        return new MiPhone();
    }
}
