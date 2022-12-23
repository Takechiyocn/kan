package designstructure.structural.struct4decorator.increase.decorator;

import designstructure.structural.struct4decorator.increase.IHouse;

/**
 * @ClassName MirrorDecorator
 * @Description
 * @Author moku
 * @Date 2022/12/23 11:13
 * @Version 1.0
 */
public class MirrorDecorator implements IMirrorHouse {
    private IHouse house;

    public MirrorDecorator(IHouse house) {
        this.house = house;
    }

    @Override
    public void live() {
        house.live();
    }

    @Override
    public void lookMirror() {
        System.out.println("新增功能：照镜子");
    }
}
