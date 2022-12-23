package designstructure.structural.struct4decorator.increase;

/**
 * @ClassName House
 * @Description
 * @Author moku
 * @Date 2022/12/23 10:59
 * @Version 1.0
 */
public class House implements IHouse {
    @Override
    public void live() {
        System.out.println("原有功能：居住");
    }
}
