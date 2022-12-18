package designstructure.creational.prototype;

import lombok.NonNull;

/**
 * @ClassName MilkTea
 * @Description
 * @Author moku
 * @Date 2022/12/18 22:04
 * @Version 1.0
 */
public class MilkTea implements Cloneable {
    public String type;
    public boolean ice;

    public String getType() {
        return type;
    }

    public boolean isIce() {
        return ice;
    }

    // @NotNull：在bean的字段注解中(通常为bean实例注解中，如entity中)
    // @NonNull：在方法或构造函数的参数上使用，表明参数、方法的值不能为null
    @NonNull
    @Override
    public MilkTea clone() throws CloneNotSupportedException {
        return (MilkTea) super.clone();
//        MilkTea milkTea = new MilkTea();
//        milkTea.type = this.type;
//        milkTea.ice = this.ice;
//        return milkTea;
    }
}
