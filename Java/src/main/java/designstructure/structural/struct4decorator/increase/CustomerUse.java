package designstructure.structural.struct4decorator.increase;

import designstructure.structural.struct4decorator.increase.decorator.IMirrorHouse;
import designstructure.structural.struct4decorator.increase.decorator.IStickyHookHouse;
import designstructure.structural.struct4decorator.increase.decorator.MirrorDecorator;
import designstructure.structural.struct4decorator.increase.decorator.StickyHookHouseDecorator;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/23 11:05
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        // 原有类
        IHouse house = new House();
        house.live();
        System.out.println("----------------------");

        // 装饰类
        IStickyHookHouse sHouse = new StickyHookHouseDecorator(house);
        // 装饰类.原有功能
        sHouse.live();
        // 装饰类.新添加功能
        sHouse.hangThings();

        System.out.println("----------------------");

        // 多个装饰类：无法同时多个装饰(同一变量中，因为装饰类不同，无法强制类型转换)
        IMirrorHouse mHouse = new MirrorDecorator(house);
        mHouse.live();
        mHouse.lookMirror();
    }
}
