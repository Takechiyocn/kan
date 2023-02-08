package designstructure.creational.factory3abstractfactory.phoneimplement;

/**
 * @ClassName MiPhone
 * @Description
 * @Author moku
 * @Date 2022/12/18 20:32
 * @Version 1.0
 */
public class MiPhone extends MobilePhone {
    @Override
    public void setOperationSystem() {
        System.out.println("小米手机安装Android系统");
    }
}
