package logic.generic.constraint;

import logic.generic.GenericTypeCommon;
import logic.occupation.Employee;

/**
 * @ClassName GenericTypeConstraint2
 * @Description 约束与局限性2：
 *                 运行时类型检查只适用于原始类型(raw type，即类型擦除后的类型)
 *                 -> 类型查询只产生原始类型
 * @Author moku
 * @Date 2022/11/26 21:43
 * @Version 1.0
 */
public class GenericTypeConstraint2 {
    public static void confirm() {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        // gt类型：GenericTypeCommon
        GenericTypeCommon<String> gt = GenericTypeCommon.minmax(words);
        // true
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (gt instanceof GenericTypeCommon) + "]");
        // Error:Illegal generic type for instanceof
//        System.out.println(gt instanceof GenericTypeCommon<String>);
        // Error
//        System.out.println(gt instanceof GenericTypeCommon<T>);
        // class:logic.generic.GenericTypeCommon
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (gt.getClass()) + "]");

        GenericTypeCommon<String>[] gt2 = (GenericTypeCommon<String>[]) new GenericTypeCommon<?>[10];
        // [Lgeneric.GenericTypeCommon;
        // -> generic.GenericTypeCommon类型数组，[L表示数组
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (gt2.getClass()) + "]");
        // equal
        // new GenericTypeCommon<Employee>();中的类型变量可省略，由编译器推导
//        GenericTypeCommon<Employee> eGenericTypeCommon = new GenericTypeCommon<Employee>();
        GenericTypeCommon<Employee> gtEmployee = new GenericTypeCommon<>();
        // true
        System.out.println("约束与局限性2：运行时类型检查只适用于原始类型[" + (gt.getClass() == gtEmployee.getClass()) + "]");
    }
}
