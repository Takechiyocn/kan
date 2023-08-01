package logic.designstructure.creational.prototype;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/18 22:06
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) throws CloneNotSupportedException {
        MilkTea milkTeaOfA = new MilkTea();
        milkTeaOfA.type = "原味";
        milkTeaOfA.ice = false;
        System.out.println("MilkTea of A:" + milkTeaOfA.type + "," + (milkTeaOfA.ice?"加冰":"不加冰"));

        MilkTea milkTeaOfB = milkTeaOfA.clone();
        System.out.println("MilkTea of B:" + milkTeaOfB.type + "," + (milkTeaOfB.ice?"加冰":"不加冰"));
    }
}
