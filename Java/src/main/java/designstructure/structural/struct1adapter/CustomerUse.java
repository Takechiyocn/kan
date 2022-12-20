package designstructure.structural.struct1adapter;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/20 22:58
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        HomeBattery homeBattery = new HomeBattery();
        int homeVolt = homeBattery.supply();
        System.out.println("家庭电源提供的电压是：" + homeVolt + "V");

        Adapter adapter = new Adapter();
        int chargeVolt = adapter.convert(homeVolt);
        System.out.println("适用适配器将家庭电压转换成了：" + chargeVolt + "V");

        USBLine usbLine = new USBLine();
        usbLine.charge(chargeVolt);
    }
}
