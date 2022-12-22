package designstructure.structural.struct2bridge.shapeif.impl;

import designstructure.structural.struct2bridge.colorif.IColor;
import designstructure.structural.struct2bridge.shapeif.IShape;

/**
 * @ClassName Rectangle
 * @Description
 * @Author moku
 * @Date 2022/12/22 16:55
 * @Version 1.0
 */
public class Rectangle implements IShape {
    private IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + this.color.getColor() + "矩形");
    }
}
