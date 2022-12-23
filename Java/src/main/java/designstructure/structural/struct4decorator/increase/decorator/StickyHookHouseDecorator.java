package designstructure.structural.struct4decorator.increase.decorator;

import designstructure.structural.struct4decorator.increase.IHouse;

/**
 * @ClassName StickyHookHouseDecorator
 * @Description
 * @Author moku
 * @Date 2022/12/23 11:03
 * @Version 1.0
 */
public class StickyHookHouseDecorator implements IStickyHookHouse {
    // 原有类
    private final IHouse house;

    public StickyHookHouseDecorator(IHouse house) {
        this.house = house;
    }

    @Override
    public void live() {
        house.live();
    }

    @Override
    public void hangThings() {
        System.out.println("新增功能：挂东西");
    }
}
