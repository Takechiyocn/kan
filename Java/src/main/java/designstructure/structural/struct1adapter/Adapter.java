package designstructure.structural.struct1adapter;

/**
 * @ClassName Adapter
 * @Description
 * @Author moku
 * @Date 2022/12/20 22:56
 * @Version 1.0
 */
public class Adapter {
    int convert(int homeVolt) {
        // 适配过程
        return homeVolt - 215;
    }
}
