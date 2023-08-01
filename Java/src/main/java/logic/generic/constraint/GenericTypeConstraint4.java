package logic.generic.constraint;

import logic.generic.GenericTypeCommon;
import logic.occupation.Employee;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName GenericTypeConstraint4
 * @Description 约束与局限性4：
 *                 泛型与可变参数
 *                 规避方法(规避约束3：不能创建参数化类型数组)：
 *                   b. 通过可变参数与泛型结合
 *                     -> 不安全
 *                   c. 参数化类型对象数组列表(容器或者其他):ArrayList<GenericTypeCommon<String>>
 *                     -> 安全
 *
 * @Author moku
 * @Date 2022/11/26 21:43
 * @Version 1.0
 */
public class GenericTypeConstraint4 {
    public static void confirm() {
        // b. 通过可变参数与泛型结合
        GenericTypeCommon<String> gt1 = new GenericTypeCommon<String>("a", "b");
        GenericTypeCommon<String> gt2 = new GenericTypeCommon<String>("c", "d");
        // 泛型与可变参数结合使用时：虚拟机将建立一个参数化类型的数组：GenericTypeCommon<String>[]，与【 约束与局限性：3】冲突，
        //   但这种情况虚拟机规则有所放松，只产生警告（unchecked generic array creation）
        // 通过@SafeVarargs消除警告
        GenericTypeCommon<String>[] gtArray = array(gt1, gt2);
        // 能赋值原因：数组存储只会检查擦除的类型，GenericTypeCommon<String>[] 擦除类型后为GenericTypeCommon[]，可转换为Object[]
        Object[] objArray = gtArray;
        objArray[0] = new GenericTypeCommon<Employee>();
        // 隐藏危险：
        //   预期：a 实际：null（objArray[0]用new初始化为空）
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过可变参数数组规避（含隐藏危险）[" + (gtArray[0].getFirst()) + "]");
        //   预期：c 实际：c
        System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过可变参数数组规避（含隐藏危险）[" + (gtArray[1].getFirst()) + "]");

        // c. 参数化类型对象数组列表(容器或者其他):ArrayList<GenericTypeCommon<String>>
        Collection<GenericTypeCommon<String>> gtArrayList = new ArrayList<GenericTypeCommon<String>>();
        GenericTypeCommon<Employee> gt3 = new GenericTypeCommon<Employee>();
        // 类型不匹配
//        gtArrayList.add(gt3);
        // 泛型与可变参数结合使用时：虚拟机将建立一个GenericTypeCommon<String>[]数组，与【 约束与局限性：3】冲突，
        // 但这种情况虚拟机规则有所放松，只产生警告（unchecked generic array creation），
        // 通过@SafeVarargs消除警告
        addAll(gtArrayList, gt1, gt2);
        GenericTypeCommon<String> gt4 = new GenericTypeCommon<String>("e", "f");
        // 给容器添加元素
        gtArrayList.add(gt4);
        // Collection容器元素打印
        for (GenericTypeCommon<String> p : gtArrayList) {
            System.out.println("约束与局限性3：不能创建参数化(此处String)类型的数组，通过数组列表规避（安全）[" + p.getFirst() + "]");
        }
    }

    /**
     * 虚拟机建立一个GenericTypeCommon<String>[]数组
     * 用@SafeVarargs标注来消除创建泛型数组的有关限制(约束与局限性：3)
     *
     * @param array
     * @param <E>
     * @return
     */
    @SafeVarargs
    public static <E> E[] array(E... array) {
        return array;
    }

    /**
     * 虚拟机建立一个GenericTypeCommon<String>[]数组
     * 用@SafeVarargs标注来消除创建泛型数组的有关限制(约束与局限性：3)
     *
     * @param coll
     * @param ts
     * @param <T>
     */
    //    @SuppressWarnings("unchecked")
    @SafeVarargs
    static <T> void addAll(Collection<T> coll, T... ts) {
        for (T t : ts) {
            coll.add(t);
        }
    }
}
