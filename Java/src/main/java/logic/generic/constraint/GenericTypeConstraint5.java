package logic.generic.constraint;

import logic.generic.GenericTypeCommon;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;

/**
 * @ClassName GenericTypeConstraint5
 * @Description 约束与局限性5：
 *                 泛型类中，不能实例化泛型实例，即不能使用new T(...)来构造泛型对象
 *                 规避方法：
 *                   a. 通过供给型接口Supplier
 *                   b. 通过反射
 *
 * @Author moku
 * @Date 2022/11/26 21:43
 * @Version 1.0
 */
public class GenericTypeConstraint5 {
    public static void confirm() {
        // a. 通过供给型接口Supplier
        //   方法引用构造器：生成空字符串
        GenericTypeCommon<String> gt = makePair(String::new);
        // 泛型类GenericTypeCommon<T>的构造器中如下定义会出错：T类型擦除为Object
        // first = new T();
        // 空字符串
        if (StringUtils.isBlank(gt.getFirst())) {
            System.out.println("约束与局限性5：能实例化泛型实例，通过供给型接口实例化类型变量[blank]");
        } else {
            System.out.println("约束与局限性5：能实例化泛型实例，通过供给型接口实例化类型变量[not blank]");
        }

        //  b. 通过反射
        //   String.class是泛型类Class<T>的实例(Class<String>)，且为唯一的实例
        GenericTypeCommon<String> gt2 = makePair(String.class);
        // 构造其中如下定义会出错：T.class类型擦除为Object.class
        // first = T.class.newInstance();
        // 空字符串
        if (StringUtils.isBlank(gt2.getFirst())) {
            System.out.println("约束与局限性5：能实例化泛型实例，通过反射实例化类型变量[blank]");
        } else {
            System.out.println("约束与局限性5：能实例化泛型实例，通过反射实例化类型变量[not blank]");
        }
    }

    /**
     * 供给型接口Supplier：无参且返回指定类型变量（此处为泛型T）
     * 泛型类型变量(T)与返回值类型(GenericTypeCommon)不同
     *
     * @param constr
     * @param <T>     表示该函数为一个泛型方法/泛型函数
     * @param <T>     GenericTypeCommon<T> ：表示返回一个泛型类的变量，即实例化GenericTypeCommon类型变量
     * @return
     */
    public static <T> GenericTypeCommon<T> makePair(Supplier<T> constr) {
        // 类型变量T可省略，由编译器推导
//        return new GenericTypeCommon<T>(constr.get(), constr.get());
        return new GenericTypeCommon<>(constr.get(), constr.get());
    }

    /**
     * 通过反射构造泛型对象
     *
     * @param cl
     * @param <T>
     * @return
     */
    public static <T> GenericTypeCommon<T> makePair(Class<T> cl) {
        try {
            return new GenericTypeCommon<>(cl.newInstance(), cl.newInstance());
        } catch (Exception ex) {
            return null;
        }
    }
}
