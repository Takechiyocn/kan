package logic.designstructure.structural.struct2bridge.shapeif.impl;

import logic.designstructure.structural.struct2bridge.colorif.IColor;
import logic.designstructure.structural.struct2bridge.shapeif.IShape;

/**
 * @ClassName Rectangle
 * @Description
 * @Author moku
 * @Date 2022/12/22 16:55
 * @Version 1.0
 */
public class Rectangle implements IShape {
    // 集合：对象包含关系，强调整体(形状)与部分(颜色)的关系
    private IColor color;

    // 依赖：以方法形参、局部变量形式体现
    public void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("绘制" + this.color.getColor() + "矩形");
    }
}
