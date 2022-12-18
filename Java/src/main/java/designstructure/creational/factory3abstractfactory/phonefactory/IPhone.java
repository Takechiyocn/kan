package designstructure.creational.factory3abstractfactory.phonefactory;

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
