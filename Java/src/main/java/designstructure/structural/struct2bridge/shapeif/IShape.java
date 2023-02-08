package designstructure.structural.struct2bridge.shapeif;

/**
 * @ClassName IShape
 * @Description
 * @Author moku
 * @Date 2022/12/22 16:51
 * @Version 1.0
 */
public interface IShape {
    // 接口只能有常量，故不能用以下方式实现聚合关系
    // IColor color;
    void draw();
}
