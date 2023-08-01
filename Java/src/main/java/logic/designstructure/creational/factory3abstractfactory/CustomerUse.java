package logic.designstructure.creational.factory3abstractfactory;

import logic.designstructure.creational.factory3abstractfactory.factory.AbstractFactory;
import logic.designstructure.creational.factory3abstractfactory.factory.AppleFactory;
import logic.designstructure.creational.factory3abstractfactory.factory.MiFactory;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:38
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        // 使用苹果工厂生产苹果公司系列产品
        AbstractFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
        appleFactory.makeMobilePhone().setOperationSystem();

        // 使用小米工厂生产小米公司系列产品
        AbstractFactory miFactory = new MiFactory();
        miFactory.makeComputer().setOperationSystem();
        miFactory.makeMobilePhone().setOperationSystem();
    }
}
