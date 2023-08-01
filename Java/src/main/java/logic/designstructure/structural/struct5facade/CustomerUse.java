package logic.designstructure.structural.struct5facade;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/23 18:59
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {
        Facade facade = new Facade();
        System.out.println("上班：");
        facade.open();

        System.out.println("下班：");
        facade.close();
    }
}
