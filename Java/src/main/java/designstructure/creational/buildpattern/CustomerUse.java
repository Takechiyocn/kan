package designstructure.creational.buildpattern;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/18 21:41
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {
        MilkTea milkTea = new MilkTea.Builder("原味").build();
        show(milkTea);

        MilkTea chocolate = new MilkTea.Builder("巧克力味")
                .ice(false)
                .build();
        show(chocolate);

        MilkTea strawberry = new MilkTea.Builder("草莓味")
                .size("大杯")
                .pearl(false)
                .ice(true)
                .build();
        show(strawberry);
    }

    private static void show(MilkTea milkTea) {
        String pearl;
        String ice;

        if (milkTea.isPearl()) {
            pearl = "加珍珠";
        } else {
            pearl = "不加珍珠";
        }
        if (milkTea.isIce()) {
            ice = "加冰";
        } else {
            ice = "不加冰";
        }

        System.out.println("一份" + milkTea.getSize() + "、"
                + pearl + "、"
                + ice + "的"
                + milkTea.getType() + "奶茶");
    }
}
