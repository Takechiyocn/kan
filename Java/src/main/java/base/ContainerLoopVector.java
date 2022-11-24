package base;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * @ClassName ContainerLoopVector
 * @Description vector遍历：vector基于数组实现，随机访问速度最快
 *              1. 标准for循环
 *              2. 增强for循环
 *              3. 增强for循环变种
 *              4. 迭代器
 *              5. Enumeration
 *              
 *              性能：标准for循环 > 迭代器 > 增强for循环(foreach)：经编译器优化后得到一个迭代器遍历
 *                   实际性能测试来看，标准for和增强for循环相差不大，可以忽略不计
 * @Author moku
 * @Date 2022/11/24 12:07
 * @Version 1.0
 */
public class ContainerLoopVector {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>() {{
           addElement("A");
           addElement("B");
           addElement("C");
        }};

        // 1. 标准for循环：对于vector而言效率最高
        for (int i = 0; i < v.size(); i++) {
            // 继承自list的get方法
            System.out.println("标准for循环：" + v.get(i));
            // vector内部方法
//            System.out.println("标准for循环：" + v.elementAt(i));
        }

        // 2. 增强for循环
        for (String str : v) {
            System.out.println("增强for循环：" + str);
        }

        // 3. 增强for循环变种：iterableObj.foreach()
        v.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("增强for循环变种：" + s);
            }
        });

        // 4. 迭代器
        Iterator<String> it = v.iterator();
//        ListIterator<String> it2 = v.listIterator();
        while (it.hasNext()) {
            System.out.println("迭代器：" + it.next());
        }

        // 5. Enumeration
        Enumeration<String> enume = v.elements();
        while (enume.hasMoreElements()) {
            System.out.println("Enumeration：" + enume.nextElement().toString());
        }

    }
}
