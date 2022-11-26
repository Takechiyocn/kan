package generic.constraint;

import generic.GenericTypeCommon;
import occupation.Employee;

/**
 * @ClassName GenericTypeConstraint3
 * @Description 约束与局限性3：
 *                 不能创建参数化(此处String/Integer等)类型的数组，即不支持泛型类型的数组
 *                 规避方法：
 *                   a. 声明通配类型的泛型数组，然后进行强制类型转换
 *                     -> 不安全
 *
 * @Author moku
 * @Date 2022/11/26 21:43
 * @Version 1.0
 */
public class GenericTypeConstraint3 {
    public static void confirm() {
        // 编译错误：generic array creation
        // GenericTypeCommon<Integer>[] gArray = new GenericTypeCommon<Integer>[10];
        GenericTypeCommon<String>[] gtArray = (GenericTypeCommon<String>[]) new GenericTypeCommon<?>[10];
        // 能赋值原因：范类型运行时只检查原始类型
        Object[] objArray = gtArray;
        gtArray[0] = new GenericTypeCommon<String>("1", "2");
        gtArray[1] = new GenericTypeCommon<String>("3", "4");
        // 能赋值原因：数组存储只会检查擦除后的类型，GenericTypeCommon<String>[] 擦除类型后为GenericTypeCommon[]，可转换为Object[]
        objArray[0] = new GenericTypeCommon<Employee>();
        // 隐藏危险：
        //   预期：1 实际：null(objArray[0]用new初始化为null)
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过通配类型数组规避（含隐藏危险）[" + (gtArray[0].getFirst()) + "]");
        //   预期：3 实际：3
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过通配类型数组规避（含隐藏危险）[" + (gtArray[1].getFirst()) + "]");
    }
}
