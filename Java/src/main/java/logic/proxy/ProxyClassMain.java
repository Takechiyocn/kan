package logic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author moku
 */
public class ProxyClassMain {
    public static void main(String[] args) {

        Object[] elements = new Object[5];

        // 填充代理元素
        for (int i = 0; i < 5; i++) {
            Integer value = i + 1;
            // 生成调用处理器(准备对Integer型的value进行代理)
            InvocationHandler handler = new TraceHandler(value);
            // 类加载器
            ClassLoader loader = null;
            // 需要实现的接口
            Class[] interfaces = new Class[]{
                    // 接口1：Comparable接口
                    Comparable.class
//                    ,
//                    // 接口2：Comparator接口
//                    Comparator.class
            };
            /**
             * 代理Comparable对象
             * 生成代理对象：无论何时调用代理对象(proxy)的方法(实现的接口方法，此处Integer实现的Comparable接口的compareTo方法)，
             *             调用处理器的invoke方法都会被调用，并向其传递Method对象（接口对象）和原始的调用参数(key)。
             * 参数1：类加载器（不同的类可以有不同的类加载器）
             * 参数2：Class对象数组。每个元素都是要实现的接口
             * 参数3：调用处理器
             */
            Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
            // 获取实现指定接口的代理类（如：proxy实现了Comparable接口）
            System.out.println("代理对象类名:"+ Proxy.getProxyClass(null,interfaces));
//            if (i == 1) {
//                proxy = Proxy.newProxyInstance(loader, new Class[]{Comparator.class}, handler);
//            }

            // 代理对象数组(可以有不同的代理对象)
            elements[i] = proxy;
        }

        // 生成随机整数
        Integer key = new Random().nextInt(elements.length);

        // 过程：
        //   1. Integer类实现了Comparable<Integer>
        //      -> 如果Integer类未实现comparable接口，则需自己实现
        //   2. 运行时调用，泛型类被取消，代理将他们构造为Comparable类的类对象
        //   3. binarySearch调用方式： if(elements[i].compareTo(key) < 0...)
        //   4. 由于数组中填充了代理对象，所以compareTo调用TraceHandler类中的invoke方法。
        //   5. 用TraceHandler类包装好的Integer对象调用comparableTo
        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}
