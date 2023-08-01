package logic.designstructure.creational.factory3abstractfactory.absclazz;

import logic.designstructure.creational.factory3abstractfactory.phoneimplement.MobilePhone;

/**
 * @ClassName IPhone
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:31
 * @Version 1.0
 */
public class IPhone extends MobilePhone {
    @Override
    public void setOperationSystem() {
        System.out.println("苹果手机安装IOS系统");
    }
}
