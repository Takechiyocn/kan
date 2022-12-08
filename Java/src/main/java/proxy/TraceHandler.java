package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 代理：可以在运行时创建一个实现了一组给定接口的新类（该功能在编译时无法确定需要实现哪个接口时才有必要使用）
 *   -> 通常情况：可以用newInstance方法或者反射找出这个类的构造器。但是接口不能实例化。
 *      低效率情况：生成代码并保存在文件中，调用编译器，加载结果类文件。->速度慢，且需编译器与程序放在一起。
 *    特点：
 *      1.所有代理类都扩展于Proxy类
 *      2.一个代理类只有一个实例域-调用处理器（定义在Proxy的超类中）
 *      3.所需要的任何附加数据都必须存储在调用处理器中
 *      4.对于特定的类加载器和预设的一组接口来说，只能有一个代理类。即使用同一个类加载器和接口数组数次调用newProxyInstance的话，只能够得到同一个类的两个对象。
 *      5.代理类一定是public和final的。
 * @author moku
 */
public class TraceHandler implements InvocationHandler {

    // 目标类：需要被代理的类
    private Object target;

    public TraceHandler(Object t) {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印显示参数
        System.out.print(target);
        // 打印方法名
        System.out.print("." + method.getName() + "(");
        // 打印隐式参数
        if (args !=null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length-1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");

        // 调用实际方法
        return method.invoke(target,args);
    }
}
