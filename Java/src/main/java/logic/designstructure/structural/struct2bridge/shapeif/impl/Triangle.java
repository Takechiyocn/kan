package logic.designstructure.structural.struct2bridge.shapeif.impl;

import logic.designstructure.structural.struct2bridge.colorif.IColor;
import logic.designstructure.structural.struct2bridge.shapeif.IShape;

/**
 * @ClassName Triangle
 * @Description
 * @Author moku
 * @Date 2022/12/22 16:58
 * @Version 1.0
 */
public class Triangle implements IShape {
    private IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + this.color.getColor() + "三角形");
    }
}
