package designstructure.structural.struct1adapter;

/**
 * @ClassName USBLine
 * @Description
 * @Author moku
 * @Date 2022/12/20 22:55
 * @Version 1.0
 */
public class USBLine {
    void charge(int volt) {
        if (volt != 5) {
            throw new IllegalArgumentException("只能接收5V电压");
        }
        System.out.println("正常充电");
    }
}
