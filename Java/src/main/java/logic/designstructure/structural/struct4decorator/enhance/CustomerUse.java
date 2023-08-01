package logic.designstructure.structural.struct4decorator.enhance;

import logic.designstructure.structural.struct4decorator.enhance.decorator.EarringDecorator;
import logic.designstructure.structural.struct4decorator.enhance.decorator.NecklaceDecorator;
import logic.designstructure.structural.struct4decorator.enhance.decorator.RingDecorator;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/23 10:23
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        IBeauty person = new Girl();
        System.out.println("原本颜值：" + person.getBeautyValue());

        // 单次装饰
        IBeauty personWithRing = new RingDecorator(person);
        System.out.println("戴上戒指后颜值：" + personWithRing.getBeautyValue());

        // 多次装饰
        IBeauty multiDecorators = new NecklaceDecorator(new EarringDecorator(new RingDecorator(person)));
        System.out.println("多次装饰后颜值：" + multiDecorators.getBeautyValue());
    }
}
