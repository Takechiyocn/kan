package designstructure.structural.struct4decorator.enhance.decorator;

import designstructure.structural.struct4decorator.enhance.IBeauty;

/**
 * @ClassName NecklaceDecorator
 * @Description
 * @Author moku
 * @Date 2022/12/23 10:21
 * @Version 1.0
 */
public class NecklaceDecorator implements IBeauty {
    // 关联association:作为类属性
    // 依赖dependency:形参、局部参数、静态方法调用
    private IBeauty object;

    public NecklaceDecorator(IBeauty object) {
        this.object = object;
    }

    @Override
    public int getBeautyValue() {
        return object.getBeautyValue() + 7;
    }
}
